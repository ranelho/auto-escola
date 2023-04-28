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
    UUID idInstrutor;
    UUID idMatricula;
    String placa;
    LocalDate data;
    HorarioAula horarioAula;
    TipoAula tipoAula;

        public static List<AgendaListResponse> converte(List<Agenda>agendas){
         return agendas.stream()
                 .map(AgendaListResponse::new)
                 .collect(Collectors.toList());
        }
        public AgendaListResponse(Agenda agenda) {
            this.idAgenda = agenda.getIdAgenda();
            this.idInstrutor = agenda.getInstrutor().getIdInstrutor();
            this.idMatricula = agenda.getMatricula().getIdMatricula();
            this.placa = agenda.getVeiculo().getPlaca();
            this.data = agenda.getData();
            this.horarioAula = agenda.getHorarioAula();
            this.tipoAula = agenda.getTipoAula();
        }
}
