package com.rlti.autoescola.exame.validation;

import com.rlti.autoescola.exame.application.api.ExameRequest;
import com.rlti.autoescola.exame.domain.Exame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static com.rlti.autoescola.exame.domain.Resultado.APTO;
import static com.rlti.autoescola.exame.domain.Resultado.INAPTO;
import static com.rlti.autoescola.exame.domain.TipoExame.*;
import static com.rlti.autoescola.exame.validation.ValidaExame.validaExame;
import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ValidaExameTest {

    @Mock
    ExameRequest request ;
    @Mock
    private List<Exame> exames;

    @BeforeEach
    public void setUp() {
        exames = new ArrayList<>();
    }

    @AfterEach
    public void tearDown() {
        exames.clear();
    }

    @Test
    public void testPrimeiroExameDeveSerClinico() {
        // Configurando o request com um tipo diferente de clínico
        request = new ExameRequest(TEORICO, now(), APTO, "");

        // Executando o método e verificando se lança exceção
        assertThrows(Exception.class, () -> validaExame(exames, request));
    }

    @Test
    public void testNaoPermitirOutroExameClinicoAposApto() {
        // Criando um mock de Exame clínico apto
        Exame exameAptoMock = mock(Exame.class);
        when(exameAptoMock.getTipoExame()).thenReturn(CLINICO);
        when(exameAptoMock.getResultado()).thenReturn(APTO);

        // Adicionando o exame clínico apto à lista de exames
        List<Exame> exames = new ArrayList<>();
        exames.add(exameAptoMock);

        // Configurando o request para ser um exame clínico
        request = new ExameRequest(CLINICO, now(), APTO, "");

        // Executando o método e verificando a exceção
        assertThrows(Exception.class, () -> validaExame(exames, request));

        // Verificando se o mock foi chamado corretamente (opcional)
        verify(exameAptoMock).getTipoExame();
        verify(exameAptoMock).getResultado();
    }

    @Test
    public void testExameTeoricoApenasAposExameClinicoApto() {
        // Criando um mock de Exame clínico apto
        Exame exameClinicoAptoMock = mock(Exame.class);
        when(exameClinicoAptoMock.getTipoExame()).thenReturn(CLINICO);
        when(exameClinicoAptoMock.getResultado()).thenReturn(APTO);

        // Adicionando o exame clínico apto à lista de exames
        List<Exame> exames = new ArrayList<>();
        exames.add(exameClinicoAptoMock);

        // Configurando o request para ser um exame teórico
        request = new ExameRequest(TEORICO, now(), APTO, "TESTE DE CLASSE");

        // Executando o método e verificando se não lança exceção
        assertDoesNotThrow(() -> validaExame(exames, request));

        // Verificando se o mock foi chamado corretamente (opcional)
        verify(exameClinicoAptoMock).getTipoExame();
        verify(exameClinicoAptoMock).getResultado();
    }

    @Test
    public void testExameTeoricoNaoPermitidoSemExameClinicoApto() {
        // Criando um mock de Exame clínico inapto
        Exame exameClinicoInaptoMock = mock(Exame.class);
        when(exameClinicoInaptoMock.getTipoExame()).thenReturn(CLINICO);
        when(exameClinicoInaptoMock.getResultado()).thenReturn(INAPTO);

        // Adicionando o exame clínico inapto à lista de exames
        List<Exame> exames = new ArrayList<>();
        exames.add(exameClinicoInaptoMock);

        // Configurando o request para ser um exame teórico
        request = new ExameRequest(TEORICO, now(), APTO, "");

        // Executando o método e verificando se lança exceção
        assertThrows(Exception.class, () -> validaExame(exames, request));

        // Verificando se o mock foi chamado corretamente (opcional)
        verify(exameClinicoInaptoMock).getTipoExame();
        verify(exameClinicoInaptoMock).getResultado();
    }

    @Test
    public void testExamePraticoApenasAposExamesClinicoETeoricoAptos() {
        // Criando mocks de Exame clínico e teórico aptos
        Exame exameClinicoAptoMock = mock(Exame.class);
        when(exameClinicoAptoMock.getTipoExame()).thenReturn(CLINICO);
        when(exameClinicoAptoMock.getResultado()).thenReturn(APTO);

        Exame exameTeoricoAptoMock = mock(Exame.class);
        when(exameTeoricoAptoMock.getTipoExame()).thenReturn(TEORICO);
        when(exameTeoricoAptoMock.getResultado()).thenReturn(APTO);

        // Adicionando os exames clínico e teórico aptos à lista de exames
        List<Exame> exames = new ArrayList<>();
        exames.add(exameClinicoAptoMock);
        exames.add(exameTeoricoAptoMock);

        // Configurando o request para ser um exame prático
        request = new ExameRequest(PRATICO, now(), APTO, "");

        // Executando o método e verificando se não lança exceção
        assertDoesNotThrow(() -> validaExame(exames, request));

        // Verificando se os mocks foram chamados corretamente (opcional)
        verify(exameClinicoAptoMock).getTipoExame();
        verify(exameClinicoAptoMock).getResultado();
        verify(exameTeoricoAptoMock).getTipoExame();
        verify(exameTeoricoAptoMock).getResultado();
    }

    @Test
    public void testExamePraticoNaoPermitidoSemExamesClinicoETeoricoAptos() {
        // Criando mocks de Exame clínico inapto e Exame teórico apto
        Exame exameClinicoInaptoMock = mock(Exame.class);
        when(exameClinicoInaptoMock.getTipoExame()).thenReturn(CLINICO);
        when(exameClinicoInaptoMock.getResultado()).thenReturn(INAPTO);

        Exame exameTeoricoAptoMock = mock(Exame.class);
        when(exameTeoricoAptoMock.getTipoExame()).thenReturn(TEORICO);
        when(exameTeoricoAptoMock.getResultado()).thenReturn(APTO);

        // Adicionando os exames clínico inapto e teórico apto à lista de exames
        exames.add(exameClinicoInaptoMock);
        exames.add(exameTeoricoAptoMock);

        // Configurando o request para ser um exame prático
        request = new ExameRequest(PRATICO, now(), APTO, "");

        // Executando o método e verificando se lança exceção
        assertThrows(Exception.class, () -> validaExame(exames, request));

        // Verificando se os mocks foram chamados corretamente (opcional)
        verify(exameClinicoInaptoMock).getTipoExame();
        verify(exameClinicoInaptoMock).getResultado();
        verify(exameTeoricoAptoMock).getTipoExame();
        verify(exameTeoricoAptoMock).getResultado();
    }
}