package com.rlti.autoescola.exame.validation;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.domain.Exame;
import com.rlti.autoescola.matricula.domain.Matricula;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.rlti.autoescola.exame.domain.Resultado.APTO;
import static com.rlti.autoescola.exame.domain.TipoExame.CLINICO;
import static com.rlti.autoescola.exame.validation.ValidaDeleteExame.validaDelete;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ValidaDeleteExameTest {


    @Test
    void testValidaDelete4() {
        ArrayList<Exame> exames = new ArrayList<>();
        Matricula matricula = new Matricula();
        Exame oneExame = new Exame(matricula,
                new ExameRequest(CLINICO, LocalDate.of(2023, 7, 21), APTO, "Observacao"));

        validaDelete(exames, oneExame);
        assertEquals("2023-07-21", oneExame.getDataExame().toString());
        assertEquals(CLINICO, oneExame.getTipoExame());
        assertEquals(APTO, oneExame.getResultado());
        assertEquals("Observacao", oneExame.getObservacao());
        assertSame(matricula, oneExame.getMatricula());
    }
}

