package com.rlti.autoescola.relatorios.application.api.respose;

import com.rlti.autoescola.cliente.domain.Cliente;
import com.rlti.autoescola.cliente.domain.enums.EstadoCivil;
import com.rlti.autoescola.contato.application.ContatoResumoResponse;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class RelatorioClientesResponse {
    UUID idCliente;
    String cpf;
    String fullName;
    LocalDate dataNascimento;
    String naturalidade;
    String nacionalidade;
    EstadoCivil estadoCivil;
    LocalDate dataCadastro;
    List<ContatoResumoResponse> contatos;
    List<RelatorioMatriculaResponse> matriculas;

    public RelatorioClientesResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.cpf = cliente.getCpf();
        this.fullName = cliente.getFullName();
        this.dataNascimento = cliente.getDataNascimento();
        this.naturalidade = cliente.getNaturalidade();
        this.nacionalidade = cliente.getNacionalidade();
        this.estadoCivil = cliente.getEstadoCivil();
        this.dataCadastro = cliente.getDateRegistration();
        this.contatos = ContatoResumoResponse.converte(cliente.getContatos());
        this.matriculas = RelatorioMatriculaResponse.converte(cliente.getMatriculas());
    }

    public static List<RelatorioClientesResponse> convert(List<Cliente> clientes) {
        return clientes.stream()
                .map(RelatorioClientesResponse::new)
                .collect((Collectors.toList()));
    }
}