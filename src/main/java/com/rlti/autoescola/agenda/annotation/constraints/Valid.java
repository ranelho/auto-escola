package com.rlti.autoescola.agenda.annotation.constraints;

import com.rlti.autoescola.agenda.application.api.AgendaRequest;
import com.rlti.autoescola.agenda.application.repository.AgendaRepository;
import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.agenda.domain.TipoAula;
import com.rlti.autoescola.handler.APIException;
import com.rlti.autoescola.instrutor.domain.Instrutor;
import com.rlti.autoescola.servico.domain.Categoria;
import org.springframework.http.HttpStatus;

import java.util.List;

public class Valid {
    private void validaSolicitacao(AgendaRequest agendaRequest, Instrutor instrutor, AgendaRepository agendaRepository) {
        isAvailabilityValid(agendaRequest.getTipoAula(),instrutor.getCategoria()), agendaRepository.getByIdAgenda();
    }

    private static void isAvailabilityValid(TipoAula tipoAula, Categoria categoria, ) {
        /*- instrutor não pode dara aula para um aluno que não compete a cnh do instrutor*/
        if (!(categoria == tipoAula)){
            throw APIException
                    .build(HttpStatus.BAD_REQUEST,"Instrutor não está apto a essa categoria");
        }else(){
            /*instrutor tem a carga horaria definida para 1 cliente por hora, verificar na agenda
            instrutor não pode dar aula para dois alunos na mesma hora.*/
            throw APIException
                    .build(HttpStatus.BAD_REQUEST,"Instrutor já possui outra aula nesse horario");
        }
    }

    /*
    - instrutor tem a carga horaria definida para 1 cliente por hora, verificar na agenda
    - instrutor não pode dar aula para dois alunos na mesma hora.
    - instrutor não pode dara aula para um aluno que não compete a cnh do instrutor
    - instrutor precisa de veiculo com tipo correta para aula
    */
    //TODO -> valida disponibilidade do instrutor
    //TODO -> instrutor tem permissão(apto) cnh para dar essa aula
    //TODO -> valida disponibilidade do veiculo
    //TODO -> verifica se esta com parte teorica, exame concluido e apto para pratica
    //TODO -> acompanha disponibilidade do aluno e carga horaria da aula

}
