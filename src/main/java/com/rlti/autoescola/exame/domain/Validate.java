package com.rlti.autoescola.exame.domain;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import static com.rlti.autoescola.exame.domain.Resultado.*;
import static com.rlti.autoescola.exame.domain.TipoExame.*;
import static com.rlti.autoescola.handler.APIException.build;
import static org.springframework.http.HttpStatus.BAD_REQUEST;


public class Validate {
    /*
     * 1 - O PRIMEIRO EXAME DEVE SER CLINICO
     * 2 - POSSO TER VARIOS EXAMES DO TIPO CLINICO, POREM TODOS TEM QUE SER INAPTO
     * 3 - SO PODE TER UM EXAME DO TIPO CLINICO COMO APTO OU A_FAZER
     * 4 - PARA O CADASTRO DO EXAME TIPO TEORICO O EXAME CLINICO DEVE SER APTO
     * 5 - POSSO TER VARIOS EXAMES DO TIPO TEORICO, POREM TEM QUE SER INAPTO
     * 6 - SO PODE TER UM EXAME DO TIPO TEORICO APTO OU A_FAZER
     * 7 - PARA UM EXAME DO TIPO PRATICO OS EXAMES CLINICO E TEORICO DEVEM SER APTO
     * 8 - POSSO TER VARIOS EXAMES DO TIPO PRATICO POREM TEM QUE SER INAPTO
     * 9 - SO PODE TER UM EXAME DO TIPO PRATICO APTO OU A_FAZER
     * */

    public static void validaExame(List<Exame> exames, ExameRequest request){
        if (exames.isEmpty() && request.getTipoExame() != CLINICO) {
            throw build(BAD_REQUEST, "O primeiro exame deve ser do tipo CLINICO");
        }
        for (Exame exame : exames) {
            if (request.getTipoExame().equals(CLINICO)) {
                if (exame.getTipoExame() == CLINICO) {
                    if (exame.getResultado() != INAPTO) {
                        throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame CLINICO");
                    } else {
                        continue;
                    }
                }
            }
            if (request.getTipoExame().equals(TEORICO)) {
                if (exame.getTipoExame() == TEORICO) {
                    if (exame.getResultado() != INAPTO) {
                        throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame TEORICO");
                    } else {
                        continue;
                    }
                }
            }
            if (request.getTipoExame().equals(PRATICO)) {
                if (exame.getTipoExame() == PRATICO) {
                    if (exame.getResultado() != INAPTO) {
                        throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame PRATICO");
                    } else {
                        continue;
                    }
                }
            }
        }
    }
}

