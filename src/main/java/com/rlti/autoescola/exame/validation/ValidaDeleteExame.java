package com.rlti.autoescola.exame.validation;

import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.handler.APIException;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.rlti.autoescola.exame.domain.Resultado.APTO;
import static com.rlti.autoescola.exame.domain.TipoExame.*;

@UtilityClass
public class ValidaDeleteExame {
    public void validaDelete(List<Exame> exames, Exame oneExame) {
        boolean clinicoApto = false;
        boolean teoricoApto = false;
        boolean praticoApto = false;

        for (Exame exame : exames) {
            if (exame.getTipoExame() == CLINICO) {
                clinicoApto = exame.getResultado() == APTO;
            } else if (exame.getTipoExame() == TEORICO) {
                teoricoApto = exame.getResultado() == APTO;
            } else if (exame.getTipoExame() == PRATICO) {
                praticoApto = exame.getResultado() == APTO;
            }
        }

        if ((praticoApto && clinicoApto && teoricoApto) ||
                (oneExame.getTipoExame().equals(CLINICO) && clinicoApto) ||
                (oneExame.getTipoExame().equals(TEORICO) && teoricoApto)) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Ação não permitida!");
        }
    }
}
