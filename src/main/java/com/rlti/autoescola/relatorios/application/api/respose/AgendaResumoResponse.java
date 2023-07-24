package com.rlti.autoescola.relatorios.application.api.respose;

import com.rlti.autoescola.agenda.domain.Agenda;
import com.rlti.autoescola.agenda.domain.HorarioAula;
import com.rlti.autoescola.agenda.domain.TipoAula;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AgendaResumoResponse {
    LocalDate data;
    HorarioAula horarioAula;
    TipoAula tipoAula;
    ClienteResumoResponse cliente;
    VeiculoResumoResponse veiculo;

    public AgendaResumoResponse(Agenda agenda) {
        this.data = agenda.getData();
        this.horarioAula = agenda.getHorarioAula();
        this.tipoAula = agenda.getTipoAula();
        this.veiculo = new VeiculoResumoResponse(agenda.getVeiculo());
        this.cliente = new ClienteResumoResponse(agenda.getMatricula().getCliente());
    }

    public static List<AgendaResumoResponse> converte(List<Agenda> agenda) {
        return agenda
                .stream()
                .map(AgendaResumoResponse::new).toList();
    }
}