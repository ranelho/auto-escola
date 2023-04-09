package com.rlti.autoescola.instrutor.application.api;

import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.servico.domain.Categoria;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Value
public class InstrutorResquest {
    @NotBlank(message = "Campo Obrigatório!")
    String nomeCompleto;
    @NotBlank(message = "Campo Obrigatório!")
    @CPF(groups = PessoaFisica.class, message = "CPF inválido!")
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    String cpf;
    @NotBlank(message = "Campo Obrigatório!")
    String cnh;
    @NotBlank(message = "Campo Obrigatório!")
    LocalDate validadeCnh;
    @NotBlank(message = "Campo Obrigatório!")
    Categoria categoria;
}