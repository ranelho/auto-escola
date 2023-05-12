package com.rlti.autoescola.instrutor.application.api;

import com.rlti.autoescola.instrutor.domain.Instrutor;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Value
public class InstrutorResponse {
    UUID idInstrutor;
    String nomeCompleto;
    String cpf;
    String cnh;
    LocalDate validadeCnh;
    String situacaoCnh;
    String categoria;

    public InstrutorResponse(Instrutor instrutor) {
        this.idInstrutor = instrutor.getIdInstrutor();
        this.nomeCompleto = instrutor.getNomeCompleto();
        this.cpf = instrutor.getCpf();
        this.cnh = instrutor.getCnh();
        this.validadeCnh = instrutor.getValidadeCnh();
        this.situacaoCnh = verificaValidadeCNH();
        this.categoria = instrutor.getCategoria().toString();
    }

    public String verificaValidadeCNH() {
        LocalDate validadeCnh = this.getValidadeCnh();
        return (validadeCnh != null && validadeCnh.isBefore(LocalDate.now())) ? "CNH VENCIDA" : "CNH VÁLIDA";
    }

    public static List<InstrutorResponse> converte(List<Instrutor> instrutors) {
        return instrutors
                .stream()
                .map(InstrutorResponse::new)
                .toList();
    }
}