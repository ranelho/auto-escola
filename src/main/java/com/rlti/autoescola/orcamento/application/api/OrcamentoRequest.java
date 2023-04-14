package com.rlti.autoescola.orcamento.application.api;

import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.matricula.application.api.request.SolicitacaoRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrcamentoRequest extends SolicitacaoRequest {
    @NotBlank(message = "Campo Obrigatório!")
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    @CPF(groups = PessoaFisica.class, message = "CPF inválido!")
    String cpf;
    @NotNull(message = "Campo Obrigatório!")
    String fullName;
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{4,5}-\\d{4}$", message = "Telefone inválido")
    String telefone;
}