package com.rlti.autoescola.agenda.domain;

import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.frota.veiculo.domain.Veiculo;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.servico.domain.Categoria;

import java.time.LocalDate;
import java.util.List;

import static com.rlti.autoescola.handler.APIException.build;
import static com.rlti.autoescola.servico.domain.Categoria.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ValidaAgenda {

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
        switch (veiculo.getTipo()) {
            case MOTOCICLETA -> {
                if (categoria != A) {
                    throw build(BAD_REQUEST, "Categoria A permitida somente para motocicletas");
                }
            }
            case AUTOMOVEL -> {
                if (categoria != B && categoria != AB) {
                    throw build(BAD_REQUEST, "Categoria B ou AB permitida somente para automóveis");
                }
            }
            case ONIBUS, MICROONIBUS -> {
                if (categoria != D) {
                    throw build(BAD_REQUEST, "Categoria D permitida somente para ônibus e micro-ônibus");
                }
            }
            case CAMINHAO -> {
                if (categoria != C) {
                    throw build(BAD_REQUEST, "Categoria E permitida somente para caminhões");
                }
            }
            case CARRETA -> {
                if (categoria != E) {
                    throw build(BAD_REQUEST, "Categoria C permitida somente para carretas");
                }
            }
            default -> throw build(BAD_REQUEST, "Tipo de veículo não reconhecido");
        }
    }

    public static void validaHorario(Instrutor instrutor, Veiculo veiculo, LocalDate data, HorarioAula horarioAula, List<Agenda> agendas) {
        for (Agenda agenda : agendas) {
            if (agenda.getData().equals(data) && agenda.getHorarioAula().equals(horarioAula)) {
                // A data e horário já estão agendados, lança uma exceção informando o usuário
                throw build(BAD_REQUEST,"Data e horário já estão agendados.");
            }
        }
    }
}