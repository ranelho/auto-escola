package com.rlti.autoescola.agenda.application.api;

import com.rlti.autoescola.agenda.domain.TipoAula;
import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Value
public class AgendaRequest {
    Long idAgenda;
    UUID idMatricula;
    String fullName;//matricula
    String cpf;//matricula
    String observacao;//matricula
    String status;//matricula
    String placa;//veiculo
    String marca;//veiculo
    TipoAula tipoAula;//agenda
    LocalDate data;//agenda
    LocalTime horario;//agenda
}
