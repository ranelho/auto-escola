package com.rlti.autoescola.exame.domain;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.handler.APIException;
import org.springframework.http.HttpStatus;

import java.util.List;

public class Validate {
    public static void validaExame(List<Exame> exames, ExameRequest request)  {
        if (exames.isEmpty() && request.getTipoExame() != TipoExame.CLINICO) {
            throw APIException
                    .build(HttpStatus.BAD_REQUEST,"O primeiro exame deve ser do tipo CLINICO");
        }
        for (Exame exame : exames) {
            //TIPO EXAME CLINICO
            if (exame.getTipoExame() == TipoExame.CLINICO && exame.getResultado() == Resultado.INAPTO
                    && request.getTipoExame() == TipoExame.CLINICO) {
                continue;
            } //ok
            if (request.getTipoExame() == TipoExame.CLINICO && exame.getResultado() == Resultado.APTO) {
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Não é permitido cadastrar outro exame CLINICO");
            } //ok
            //TIPO EXAME TEORICO
            if ((request.getTipoExame() == TipoExame.TEORICO && exame.getTipoExame() == TipoExame.CLINICO && exame.getResultado() == Resultado.APTO) ||
                    (request.getTipoExame() == TipoExame.TEORICO && exame.getTipoExame() == TipoExame.TEORICO && exame.getResultado() == Resultado.INAPTO)) {
                continue;
            } //ok
            if ((request.getTipoExame() == TipoExame.TEORICO && exame.getResultado() == Resultado.APTO) ||
                    (request.getTipoExame() == TipoExame.TEORICO && exame.getResultado() == Resultado.A_FAZER)){
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Não é permitido cadastrar outro exame TEORICO");
            } //ok
            //TIPO EXAME PRATICO
            if ((request.getTipoExame() == TipoExame.PRATICO && exame.getTipoExame() == TipoExame.TEORICO && exame.getResultado() == Resultado.APTO) ||
                    ((request.getTipoExame() == TipoExame.PRATICO && exame.getTipoExame() == TipoExame.PRATICO && exame.getResultado() == Resultado.INAPTO)) ){
                continue;
            } //ok
            if ((request.getTipoExame() == TipoExame.PRATICO && exame.getTipoExame() == TipoExame.PRATICO && exame.getResultado() == Resultado.APTO) ||
                    (request.getTipoExame() == TipoExame.PRATICO && exame.getTipoExame() == TipoExame.PRATICO && exame.getResultado() == Resultado.A_FAZER)){
                throw APIException
                        .build(HttpStatus.BAD_REQUEST,"Não é permitido cadastrar outro exame PRATICO");
            }//ok
        }
    }
}