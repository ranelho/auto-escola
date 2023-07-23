package com.rlti.autoescola.exame.validation;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.exame.domain.Resultado;
import com.rlti.autoescola.exame.domain.TipoExame;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.List;

import static com.rlti.autoescola.exame.domain.Resultado.APTO;
import static com.rlti.autoescola.exame.domain.Resultado.INAPTO;
import static com.rlti.autoescola.exame.domain.TipoExame.*;
import static com.rlti.autoescola.handler.APIException.build;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class ValidaExame {
    public static void validaExame(List<Exame> exames, ExameRequest request) {
        EnumMap<TipoExame, Resultado> resultados = new EnumMap<>(TipoExame.class);
        for (Exame exame : exames) {
            resultados.put(exame.getTipoExame(), exame.getResultado());
        }

        if (exames.isEmpty() && request.tipoExame() != CLINICO) {
            throw build(BAD_REQUEST, "O primeiro exame deve ser do tipo CLINICO");
        }

        switch (request.tipoExame()) {
            case CLINICO -> validaExameClinico(resultados);
            case TEORICO -> validaExameTeorico(resultados);
            case PRATICO -> validaExamePratico(resultados);
        }
    }

    private static void validaExameClinico(EnumMap<TipoExame, Resultado> resultados) {
        if (resultados.containsKey(CLINICO) && resultados.get(CLINICO) != INAPTO) {
            throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame CLINICO");
        }
    }

    private static void validaExameTeorico(EnumMap<TipoExame, Resultado> resultados) {
        if (!resultados.containsKey(CLINICO) || resultados.get(CLINICO) != APTO) {
            throw build(BAD_REQUEST, "Para cadastrar um exame TEORICO, o exame CLINICO deve estar APTO");
        }
        if (resultados.containsKey(TEORICO) && resultados.get(TEORICO) == APTO) {
            throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame TEORICO APTO");
        }
    }

    private static void validaExamePratico(EnumMap<TipoExame, Resultado> resultados) {
        if (!resultados.containsKey(CLINICO) || resultados.get(CLINICO) != APTO ||
                !resultados.containsKey(TEORICO) || resultados.get(TEORICO) != APTO) {
            throw build(BAD_REQUEST, "Para cadastrar um exame PRATICO, os exames CLINICO e TEORICO devem estar APTOS");
        }
        if (resultados.containsKey(PRATICO) && resultados.get(PRATICO) == APTO) {
            throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame TEORICO APTO");
        }
    }
}