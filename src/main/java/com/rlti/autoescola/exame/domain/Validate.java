package com.rlti.autoescola.exame.domain;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.handler.APIException;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.rlti.autoescola.exame.domain.TipoExame.*;

public class Validate {
    public static void validaExame(List<Exame> exames, ExameRequest request)  {
        if (exames.isEmpty() && request.getTipoExame() != CLINICO) {
            throw APIException
                    .build(HttpStatus.BAD_REQUEST,"O primeiro exame deve ser do tipo CLINICO");
        }
        for (Exame exame : exames) {
            if (exame.getTipoExame() == CLINICO && exame.getResultado() == Resultado.INAPTO
                    && request.getTipoExame() == CLINICO) {
                continue;
            }
            if (request.getTipoExame() == CLINICO && exame.getResultado() == Resultado.APTO) {
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Não é permitido cadastrar outro exame CLINICO");
            }
            if ((request.getTipoExame() == TEORICO && exame.getTipoExame() == CLINICO && exame.getResultado() == Resultado.APTO) ||
                    (request.getTipoExame() == TEORICO && exame.getTipoExame() == TEORICO && exame.getResultado() == Resultado.INAPTO)) {
                continue;
            }
            if ((request.getTipoExame() == TEORICO && exame.getResultado() == Resultado.APTO) ||
                    (request.getTipoExame() == TEORICO && exame.getResultado() == Resultado.A_FAZER)){
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Não é permitido cadastrar outro exame TEORICO");
            }
            if ((request.getTipoExame() == PRATICO && exame.getTipoExame() == TEORICO && exame.getResultado() == Resultado.APTO) ||
                    ((request.getTipoExame() == PRATICO && exame.getTipoExame() == PRATICO && exame.getResultado() == Resultado.INAPTO)) ){
                continue;
            }
            if ((request.getTipoExame() == PRATICO && exame.getTipoExame() == PRATICO && exame.getResultado() == Resultado.APTO) ||
                    (request.getTipoExame() == PRATICO && exame.getTipoExame() == PRATICO && exame.getResultado() == Resultado.A_FAZER)){
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Não é permitido cadastrar outro exame PRATICO");
            }
        }
    }
}