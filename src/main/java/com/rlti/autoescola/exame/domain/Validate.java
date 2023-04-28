package com.rlti.autoescola.exame.domain;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.handler.APIException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import java.util.List;

@Log4j2
public class Validate {
    public static void validaExame(List<Exame> exames, ExameRequest request) {
        if (exames.isEmpty()) {
            throw new RuntimeException("Não existem exames cadastrados para a matrícula informada.");
        }

        TipoExame tipoExame = request.getTipoExame();
        Resultado resultado = request.getResultado();

        if (tipoExame == TipoExame.CLINICO) {
            boolean primeiroExameClinico = exames.get(0).getTipoExame() == TipoExame.CLINICO;
            if (!primeiroExameClinico) {
                throw APIException.build(HttpStatus.BAD_REQUEST,"O primeiro exame da lista precisa ser do tipo CLINICO.");
            }

            boolean todosInapto = exames.stream()
                    .filter(exame -> exame.getTipoExame() == TipoExame.CLINICO)
                    .allMatch(exame -> exame.getResultado() == Resultado.INAPTO);
            if (!todosInapto) {
                throw  APIException.build(HttpStatus.BAD_REQUEST,"Todos os exames do tipo CLINICO devem ter resultado INAPTO.");
            }

            boolean temAptoOuAFazer = exames.stream()
                    .filter(exame -> exame.getTipoExame() == TipoExame.CLINICO)
                    .anyMatch(exame -> exame.getResultado() == Resultado.APTO || exame.getResultado() == Resultado.A_FAZER);
            if (temAptoOuAFazer) {
                throw APIException.build(HttpStatus.BAD_REQUEST,"Não pode haver exames CLINICO com resultado APTO ou A_FAZER.");
            }
        } else if (tipoExame == TipoExame.TEORICO) {
            boolean temClinicoApto = exames.stream()
                    .filter(exame -> exame.getTipoExame() == TipoExame.CLINICO && exame.getResultado() == Resultado.APTO)
                    .findFirst()
                    .isPresent();
            if (!temClinicoApto) {
                throw new RuntimeException("É necessário ter pelo menos um exame CLINICO APTO para o exame TEORICO.");
            }

            boolean todosInapto = exames.stream()
                    .filter(exame -> exame.getTipoExame() == TipoExame.TEORICO)
                    .allMatch(exame -> exame.getResultado() == Resultado.INAPTO);
            if (!todosInapto) {
                throw new RuntimeException("Todos os exames do tipo TEORICO devem ter resultado INAPTO.");
            }

            boolean jaRealizado = exames.stream()
                    .filter(exame -> exame.getTipoExame() == TipoExame.TEORICO && exame.getResultado() != Resultado.A_FAZER)
                    .findFirst()
                    .isPresent();
            if (jaRealizado) {
                throw  APIException.build(HttpStatus.BAD_REQUEST,"Já existe um exame TEORICO realizado para a matrícula informada.");
            }
        } else {
            throw  APIException.build(HttpStatus.BAD_REQUEST,"Tipo de exame inválido.");
        }
    }
}

