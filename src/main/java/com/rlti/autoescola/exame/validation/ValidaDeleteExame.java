package com.rlti.autoescola.exame.validation;

import com.rlti.autoescola.exame.domain.Exame;
import lombok.experimental.UtilityClass;

import java.util.List;

import static com.rlti.autoescola.exame.domain.Resultado.APTO;
import static com.rlti.autoescola.exame.domain.TipoExame.*;
import static com.rlti.autoescola.handler.APIException.build;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@UtilityClass
public class ValidaDeleteExame {
    public void validaDelete(List<Exame> exames, Exame oneExame) {
        boolean clinicoApto = exames.stream()
                .filter(e -> e.getTipoExame() == CLINICO)
                .anyMatch(exame -> exame.getResultado() == APTO);

        boolean teoricoApto = exames.stream()
                .filter(e -> e.getTipoExame() == TEORICO)
                .anyMatch(exame -> exame.getResultado() == APTO);

        boolean praticoApto = exames.stream()
                .filter(e -> e.getTipoExame() == PRATICO)
                .anyMatch(exame -> exame.getResultado() == APTO);

        if ((praticoApto && clinicoApto && teoricoApto) ||
                (oneExame.getTipoExame().equals(CLINICO) && clinicoApto) ||
                (oneExame.getTipoExame().equals(TEORICO) && teoricoApto)) {
            throw build(BAD_REQUEST, "Ação não permitida!");
        }
    }
}
