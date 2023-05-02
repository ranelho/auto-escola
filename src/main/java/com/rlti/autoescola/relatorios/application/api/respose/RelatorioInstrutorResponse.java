package com.rlti.autoescola.relatorios.application.api.respose;

import com.rlti.autoescola.instrutor.domain.Instrutor;
import lombok.Data;

import java.util.List;

@Data
public class RelatorioInstrutorResponse {
    String nomeCompleto;
    String cpf;
    String cnh;
    String Categoria;
    String status;
    List<AgendaResumoResponse> agendas;

    public RelatorioInstrutorResponse(Instrutor instrutor) {
        this.nomeCompleto = instrutor.getNomeCompleto();
        this.cpf = instrutor.getCpf();
        this.cnh = instrutor.getCnh();
        this.Categoria = instrutor.getCategoria().toString();
        this.status = instrutor.getStatus().toString();
        this.agendas = AgendaResumoResponse.converte(instrutor.getAgendas());
    }

    public static List<RelatorioInstrutorResponse> converte(List<Instrutor> instrutors) {
        return instrutors
                .stream().map(RelatorioInstrutorResponse::new).toList();
    }
}
