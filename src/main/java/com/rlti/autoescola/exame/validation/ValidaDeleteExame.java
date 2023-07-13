package com.rlti.autoescola.exame.validation;

import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.handler.APIException;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.rlti.autoescola.exame.domain.Resultado.APTO;
import static com.rlti.autoescola.exame.domain.TipoExame.*;

@Log4j2
@UtilityClass
public class ValidaDeleteExame {

    public static void validaDelete(List<Exame> exames, Exame oneExame) {
        /*
         * 1 - CLINICO -> SE CLINICO INAPTO PODE EXCLUIR
         * 2 - TEORICO -> SE CLINICO APTO E TEORICO INAPTO PODE EXCLUIR
         * 3 - PRATICO -> SE CLINICO APTO E TEORICO APTO E PRATICO INAPTO PODE EXCLUIR
         * */
        boolean hasClinicoApto = false;
        boolean hasTeoricoApto = false;
        boolean hasPraticoApto = false;
        String mensagemAcaoNaoPermitida = "Ação não permitida!";

        for (Exame exame : exames) {
            log.info("[INICIO-FOR]");
            if (exame.getTipoExame() == CLINICO && exame.getResultado() == APTO) {
                log.info("[CLINICO] {}", exame.getIdExame());
                hasClinicoApto = true;
            }
            if (exame.getTipoExame() == TEORICO && exame.getResultado() == APTO) {
                log.info("[TEORICO] {}", exame.getIdExame());
                hasTeoricoApto = true;
            }
            if (exame.getTipoExame() == PRATICO && exame.getResultado() == APTO) {
                log.info("[PRATICO] {}", exame.getIdExame());
                hasPraticoApto = true;
            }
            log.info("[FIM-FOR]");
        }

        log.info("[INICIO-VERIFICAÇÃO]");
        if ((hasPraticoApto && hasClinicoApto && hasTeoricoApto) ||
                (oneExame.getTipoExame().equals(CLINICO) && hasClinicoApto) ||
                (oneExame.getTipoExame().equals(TEORICO) && hasTeoricoApto)) {
            throw APIException.build(HttpStatus.BAD_REQUEST, mensagemAcaoNaoPermitida);
        }
    }
}
