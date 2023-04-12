package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.matricula.domain.TipoPagamento;
import com.rlti.autoescola.matricula.domain.TipoServico;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.util.UUID;

@Data
public class OrcamentoRequest {
    @NotBlank(message = "Campo Obrigatório!")
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    @CPF(groups = PessoaFisica.class, message = "CPF inválido!")
    String cpf;
    @NotNull(message = "Campo Obrigatório!")
    String fullName;
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{4,5}-\\d{4}$", message = "Telefone inválido")
    String telefone;
    UUID idServico;
    TipoPagamento tipoPagamento;
    Double valorEntrada;
    int desconto;
    @Min(value = 1, message = "O valor mínimo é 1")
    @Max(value = 12, message = "O valor máximo é 12")
    int quantidadeParcelas;
    String observacao;
    TipoServico tipoServico;
}