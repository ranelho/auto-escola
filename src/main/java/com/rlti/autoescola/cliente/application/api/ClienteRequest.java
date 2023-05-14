package com.rlti.autoescola.cliente.application.api;

import com.rlti.autoescola.cliente.annotation.Adult;
import com.rlti.autoescola.cliente.domain.enums.EstadoCivil;
import com.rlti.autoescola.cliente.domain.groups.PessoaFisica;
import jakarta.validation.constraints.Email;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

@Value
public class ClienteRequest {
    @NotBlank(message = "Campo Obrigatório!")
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    @CPF(groups = PessoaFisica.class, message = "CPF inválido!")
    String cpf;
    @NotNull(message = "Campo Obrigatório!")
    String fullName;
    @Adult
    LocalDate dataNascimento;
    String naturalidade;
    String nacionalidade;
    EstadoCivil estadoCivil;
    @Email(message = "Email inválido!")
    String email;
}
