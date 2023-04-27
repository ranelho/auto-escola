package com.rlti.autoescola.exame.domain;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.handler.APIException;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.rlti.autoescola.exame.domain.Resultado.*;
import static com.rlti.autoescola.exame.domain.TipoExame.*;

public class Validate {
    public static void validaExame(List<Exame> exames, ExameRequest request)  {
        if (exames.isEmpty() && request.getTipoExame() != CLINICO) {
            throw APIException.build(HttpStatus.BAD_REQUEST,"O primeiro exame deve ser do tipo CLINICO");
        }
        for (Exame exame : exames) {
            //valida exame clinico
            if (request.getTipoExame() == CLINICO && exame.getTipoExame() == CLINICO && exame.getResultado() == APTO) {
                throw APIException.build(HttpStatus.BAD_REQUEST,"Não é permitido cadastrar outro exame CLINICO");
            }//OK
            if (request.getTipoExame() == TEORICO && exame.getTipoExame() == TEORICO && exame.getResultado() == APTO){
                throw APIException.build(HttpStatus.BAD_REQUEST,"Não é permitido cadastrar outro exame TEORICO");
            }
            if (request.getTipoExame() == PRATICO && exame.getTipoExame() == PRATICO && exame.getResultado() == APTO){
                throw APIException.build(HttpStatus.BAD_REQUEST,"Não é permitido cadastrar outro exame PRATICO");
            }
            //valida exame clinico
            if(request.getTipoExame().equals(CLINICO)){
                if ((exame.getTipoExame() == CLINICO && exame.getResultado() == INAPTO)
                        || exame.getTipoExame() == CLINICO && exame.getResultado() != A_FAZER) {
                    continue;
                }
            }
            //valida exame teorico
            if ((request.getTipoExame() == TEORICO && exame.getTipoExame() == CLINICO && exame.getResultado() == APTO) || (request.getTipoExame() == TEORICO && exame.getTipoExame() == TEORICO && exame.getResultado() == INAPTO)) {
                continue;
            }
            if ((request.getTipoExame() == PRATICO && exame.getTipoExame() == TEORICO && exame.getResultado() == APTO) || ((request.getTipoExame() == PRATICO && exame.getTipoExame() == PRATICO && exame.getResultado() == INAPTO)) ){
                continue;
            }

        }
    }
}