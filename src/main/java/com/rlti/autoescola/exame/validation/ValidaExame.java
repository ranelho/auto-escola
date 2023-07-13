package com.rlti.autoescola.exame.validation;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.domain.Exame;

import java.util.List;

import static com.rlti.autoescola.exame.domain.Resultado.APTO;
import static com.rlti.autoescola.exame.domain.Resultado.INAPTO;
import static com.rlti.autoescola.exame.domain.TipoExame.*;
import static com.rlti.autoescola.handler.APIException.build;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Ranelho Lacerda
 */
public class ValidaExame {
    /**
     * Método para Validar Exame
     * @param exames recebe uma lista com os exames cadastrados
     * @param request recebe as informações vindo do usuario
     * -----------------REGRAS---------------
     * 1 - O PRIMEIRO EXAME DEVE SER CLINICO
     * 2 - PODE-SE TER VÁRIOS EXAMES DO TIPO CLINICO, POREM TODOS TEM QUE SER INAPTO
     * 3 - SO PODE TER UM EXAME DO TIPO CLINICO COMO APTO OU A_FAZER
     * 4 - PARA O CADASTRO DO EXAME TIPO TEORICO O EXAME CLINICO DEVE SER APTO
     * 5 - PODE-SE TER VÁRIOS EXAMES DO TIPO TEORICO, POREM TEM QUE SER INAPTO
     * 6 - SO PODE TER UM EXAME DO TIPO TEORICO APTO OU A_FAZER
     * 7 - PARA UM EXAME DO TIPO PRATICO OS EXAMES CLINICO E TEORICO DEVEM SER APTO
     *  8 - PODE-SE TER VÁRIOS EXAMES DO TIPO PRATICO POREM TEM QUE SER INAPTO
     *  9 - SO PODE TER UM EXAME DO TIPO PRATICO APTO OU A_FAZER
     */
    public static void validaExame(List<Exame> exames, ExameRequest request) {
        boolean hasClinicoApto = false;
        boolean hasTeoricoApto = false;

        if (exames.isEmpty() && request.tipoExame() != CLINICO) {
            throw build(BAD_REQUEST, "O primeiro exame deve ser do tipo CLINICO");
        }
        if (request.tipoExame().equals(TEORICO)) {
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
        if (request.tipoExame().equals(CLINICO)) {
            for (Exame exame : exames) {
                if (exame.getTipoExame() == CLINICO && exame.getResultado() != INAPTO) {
                    throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame CLINICO");
                }
            }
        }
        if (request.tipoExame().equals(TEORICO)) {
            for (Exame exame : exames) {
                if (exame.getTipoExame() == TEORICO && exame.getResultado() != INAPTO) {
                    throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame TEORICO");
                }
            }
        }
        if (request.tipoExame().equals(PRATICO)) {
            for (Exame exame : exames) {
                if (exame.getTipoExame() == PRATICO && exame.getResultado() != INAPTO) {
                    throw build(BAD_REQUEST, "Não é permitido cadastrar outro exame PRATICO");
                }
            }
        }
        if (request.tipoExame().equals(PRATICO)) {
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