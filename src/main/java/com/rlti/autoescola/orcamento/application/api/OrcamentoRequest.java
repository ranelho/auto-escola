package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class OrcamentoRequest {
    @NotBlank(message = "Campo Obrigatório!")
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    @CPF(groups = PessoaFisica.class, message = "CPF inválido!")
    private String cpf;
    @NotNull(message = "Campo Obrigatório!")
    private String fullName;
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{4,5}\\-\\d{4}$", message = "Telefone inválido")
    String telefone;
    UUID idServico;
    TipoPagamento tipoPagamento;
    LocalDate dataOrcamento;
    Double valorEntrada;
    int desconto;
    int quantidadeParcelas;
    String observacao;
    TipoServico tipoServico;
}
