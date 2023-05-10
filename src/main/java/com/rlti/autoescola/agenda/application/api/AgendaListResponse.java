package com.rlti.autoescola.agenda.application.api;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.agenda.domain.TipoAula;
import lombok.Value;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class AgendaListResponse {
    Long idAgenda;
    String instrutor;
    String aluno;
    String servico;
    String veiculo;
    LocalDate data;
    String horarioAula;
    TipoAula tipoAula;

        public static List<AgendaListResponse> converte(List<Agenda>agendas){
         return agendas.stream()
                 .map(AgendaListResponse::new)
                 .collect(Collectors.toList());
        }
        public AgendaListResponse(Agenda agenda) {
            this.idAgenda = agenda.getIdAgenda();
            this.instrutor = agenda.getInstrutor().getNomeCompleto();
            this.aluno = agenda.getMatricula().getCliente().getFullName();
            this.servico = agenda.getMatricula().getServico().getCategoria().toString();
            this.veiculo = agenda.getVeiculo().getModelo() + " - "+ agenda.getVeiculo().getPlaca();
            this.data = agenda.getData();
            this.horarioAula = agenda.getHorarioAula().toString();
            this.tipoAula = agenda.getTipoAula();
        }
}
