package com.rlti.autoescola.instrutor.application.api;

import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import com.rlti.autoescola.servico.domain.Categoria;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

@Value
public class InstrutorResquest {
    @NotNull(message = "Campo Obrigatório!")
    String nomeCompleto;
    @NotNull(message = "Campo Obrigatório!")
    @CPF(groups = PessoaFisica.class, message = "CPF inválido!")
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    String cpf;
    @NotNull(message = "Campo Obrigatório!")
    String cnh;
    @NotNull(message = "Campo Obrigatório!")
    LocalDate validadeCnh;
    @NotNull(message = "Campo Obrigatório!")
    Categoria categoria;
}