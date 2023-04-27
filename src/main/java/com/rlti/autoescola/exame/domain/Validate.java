package com.rlti.autoescola.exame.domain;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.handler.APIException;

import java.util.List;

import static com.rlti.autoescola.exame.domain.Resultado.*;
import static com.rlti.autoescola.exame.domain.TipoExame.*;
import static com.rlti.autoescola.handler.APIException.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class Validate {
    public static void validaExame(List<Exame> exames, ExameRequest request)  {
        if (exames.isEmpty() && request.getTipoExame() != CLINICO) {
            throw build(BAD_REQUEST,"O primeiro exame deve ser do tipo CLINICO");
        }
        for (Exame exame : exames) {
            //valida exame clinico
            if(request.getTipoExame().equals(CLINICO)){
                if (exame.getTipoExame() == CLINICO && exame.getResultado() == APTO || exame.getResultado() == A_FAZER) {
                    throw build(BAD_REQUEST,"Não é permitido cadastrar outro exame CLINICO");
                }else {
                    continue;
                }
            }
            //valida exame teorico
            if(request.getTipoExame().equals(TEORICO)){
                if (exame.getTipoExame() == TEORICO && exame.getResultado() == APTO || exame.getResultado() == A_FAZER){
                    throw build(BAD_REQUEST,"Não é permitido cadastrar outro exame TEORICO");
                }
                if ((exame.getTipoExame() == CLINICO && exame.getResultado() == APTO)
                || (exame.getTipoExame() == TEORICO && exame.getResultado() == INAPTO)){
                    continue;
                }
            }
            //valida pratico
            if(request.getTipoExame().equals(PRATICO)){
                if (exame.getTipoExame() == PRATICO && exame.getResultado() == APTO || exame.getResultado() == A_FAZER){
                    throw build(BAD_REQUEST,"Não é permitido cadastrar outro exame PRATICO");
                }
                if ((exame.getTipoExame() == TEORICO && exame.getResultado() == APTO)
                    || (exame.getTipoExame() == PRATICO && exame.getResultado() == INAPTO)){
                    continue;
                }
            }
        }
    }
}