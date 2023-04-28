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

    public static void validaExame(List<Exame> exames, ExameRequest request) {
        if (exames.isEmpty() && request.getTipoExame() != CLINICO) {
            throw build(BAD_REQUEST, "O primeiro exame deve ser do tipo CLINICO");
        }

        // Verifica se o primeiro exame é CLINICO e está APTO ou A_FAZER antes de permitir cadastrar um exame TEORICO
        if (request.getTipoExame().equals(TEORICO)) {
            boolean hasClinicoApto = false;
            for (Exame exame : exames) {
                if (exame.getTipoExame() == CLINICO && exame.getResultado() == APTO) {
                    hasClinicoApto = true;
                    break;
                }
            }
            if (!hasClinicoApto) {
                throw build(BAD_REQUEST, "Para cadastrar um exame TEORICO, o exame CLINICO deve estar APTO");
            }
        }

        // Verifica se já existe um exame CLINICO APTO ou A_FAZER antes de permitir cadastrar outro exame CLINICO
        if (request.getTipoExame().equals(CLINICO)) {
            for (Exame exame : exames) {
                if (exame.getTipoExame() == CLINICO) {
                    if (exame.getResultado() != INAPTO) {
                        throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame CLINICO");
                    } else {
                        continue;
                    }
                }
            }
        }

        // Verifica se já existe um exame TEORICO APTO ou A_FAZER antes de permitir cadastrar outro exame TEORICO
        if (request.getTipoExame().equals(TEORICO)) {
            for (Exame exame : exames) {
                if (exame.getTipoExame() == TEORICO) {
                    if (exame.getResultado() != INAPTO) {
                        throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame TEORICO");
                    } else {
                        continue;
                    }
                }
            }
        }

        // Verifica se já existe um exame PRATICO APTO ou A_FAZER antes de permitir cadastrar outro exame PRATICO
        if (request.getTipoExame().equals(PRATICO)) {
            for (Exame exame : exames) {
                if (exame.getTipoExame() == PRATICO) {
                    if (exame.getResultado() != INAPTO) {
                        throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame PRATICO");
                    } else {
                        continue;
                    }
                }
            }
        }

        // Verifica se existe um exame CLINICO e um exame TEORICO APTO antes de permitir cadastrar um exame PRATICO
        if (request.getTipoExame().equals(PRATICO)) {
            boolean hasClinicoApto = false;
            boolean hasTeoricoApto = false;
            for (Exame exame : exames) {
                if (exame.getTipoExame() == CLINICO && exame.getResultado() == APTO) {
                    hasClinicoApto = true;
                }
                if (exame.getTipoExame() == TEORICO && exame.getResultado() == APTO) {
                    hasTeoricoApto = true;
                }
            }
            if (!hasClinicoApto || !hasTeoricoApto) {
                throw build(BAD_REQUEST, "Para cadastrar um exame PRATICO, os exames CLINICO e TEORICO devem estar APTOS");
            }
        }
    }
}