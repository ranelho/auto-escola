package com.rlti.autoescola.instrutor.application.api;

import com.rlti.autoescola.instrutor.domain.Instrutor;
import lombok.Value;

import java.time.LocalDate;

@Value
public class InstrutorResponse {
    String nomeCompleto;
    String cpf;
    String cnh;
    LocalDate validadeCnh;
    String categoria;

    public InstrutorResponse(Instrutor instrutor) {
        this.nomeCompleto = instrutor.getNomeCompleto();
        this.cpf = instrutor.getCpf();
        this.cnh = instrutor.getCnh();
        this.validadeCnh = instrutor.getValidadeCnh();
        this.categoria = instrutor.getCategoria().toString();
    }
}