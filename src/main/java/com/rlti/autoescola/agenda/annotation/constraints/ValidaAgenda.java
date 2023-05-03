package com.rlti.autoescola.agenda.annotation.constraints;

import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.frota.veiculo.domain.Tipo;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.matricula.domain.Matricula;
import com.rlti.autoescola.servico.domain.Categoria;
import lombok.extern.log4j.Log4j2;

import java.util.*;

import static com.rlti.autoescola.handler.APIException.build;
import static com.rlti.autoescola.servico.domain.Categoria.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Log4j2
public class ValidaAgenda {

    public static void isValid(Instrutor instrutor, Matricula matricula, Veiculo veiculo, AgendaRequest request,
                               List<Agenda> agendasPorData) {
        validaInstrutorServico(instrutor, matricula.getServico().getCategoria());
        validaVeiculoServico(veiculo, matricula.getServico().getCategoria());
        validaHorario(instrutor, veiculo, matricula,request, agendasPorData);
    }

    public static void validaInstrutorServico(Instrutor instrutor, Categoria categoria) {
        if (categoria == ACC && instrutor.getCategoria() != ACC) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria ACC");
        } else if (categoria == AB &&
                (instrutor.getCategoria() != A && instrutor.getCategoria() != B && instrutor.getCategoria() != AB)) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria AB, A ou B");
        } else if (categoria == A && instrutor.getCategoria() != A) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria A");
        } else if (categoria == B && instrutor.getCategoria() != B) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria B");
        } else if (categoria == C && instrutor.getCategoria() != C) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria C");
        } else if (categoria == D && instrutor.getCategoria() != D) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria D");
        } else if (categoria == AD &&
                (instrutor.getCategoria() != A && instrutor.getCategoria() != B && instrutor.getCategoria() != C
                        && instrutor.getCategoria() != D && instrutor.getCategoria() != AB)) {
            throw build(BAD_REQUEST,"Instrutor não possui categoria AD, A, B, C, D ou AB");
        }
    }

    public static void validaVeiculoServico(Veiculo veiculo, Categoria categoria) {
        Map<Tipo, Set<Categoria>> categoriasPermitidas = Map.of(
                Tipo.MOTOCICLETA, Set.of(Categoria.A),
                Tipo.AUTOMOVEL, Set.of(Categoria.B, Categoria.AB),
                Tipo.ONIBUS, Set.of(Categoria.D),
                Tipo.MICROONIBUS, Set.of(Categoria.D),
                Tipo.CAMINHAO, Set.of(Categoria.C),
                Tipo.CARRETA, Set.of(Categoria.E)
        );
        Set<Categoria> categorias = categoriasPermitidas.get(veiculo.getTipo());
        if (categorias == null) {
            throw build(BAD_REQUEST, "Tipo de veículo não reconhecido");
        }
        if (!categorias.contains(categoria)) {
            throw build(BAD_REQUEST, String.format("Categoria %s não permitida para este tipo de veículo", categoria));
        }
    }

    public static void validaHorario(Instrutor instrutor, Veiculo veiculo, Matricula matricula, AgendaRequest request,
                                     List<Agenda> agendasPorData) {
        for (Agenda agenda : agendasPorData) {
            //1 - Validar cliente horario e horario
            if (agenda.getData().equals(request.getData()) && agenda.getHorarioAula().equals(request.getHorarioAula())
                    && agenda.getMatricula().getCliente().equals(matricula.getCliente())) {
                List<HorarioAula> horariosDisponiveis = getHorariosDisponiveis(agendasPorData);
                throw build(BAD_REQUEST,"Data e horário já estão agendados, segue horarios disponiveis:"
                        +  horariosDisponiveis);
            }
            //2 - Validar veiculo e horario
            if(agenda.getVeiculo().getPlaca().equals(veiculo.getPlaca()) && agenda.getHorarioAula().equals(request.getHorarioAula())
                    && agenda.getData().equals(request.getData())){
                throw build(BAD_REQUEST,"Veículo já está agendado neste horário.");
            }
            //3 - Validar Instrutor e horario
            if(agenda.getInstrutor().getIdInstrutor().equals(instrutor.getIdInstrutor())
                    && agenda.getHorarioAula().equals(request.getHorarioAula())
                    && agenda.getData().equals(request.getData())){
                throw build(BAD_REQUEST,"Instrutor já está agendado neste horário.");
            }
        }
    }

    public static List<HorarioAula> getHorariosDisponiveis(List<Agenda> agendasPorData) {
        List<HorarioAula> horariosDisponiveis = new ArrayList<>(Arrays.asList(HorarioAula.values()));
        for (Agenda agenda : agendasPorData) {
            HorarioAula horarioMarcado = HorarioAula.valueOf(agenda.getHorarioAula().toString());
            horariosDisponiveis.remove(horarioMarcado);
        }
        return horariosDisponiveis;
    }
}