package com.rlti.autoescola.instrutor.application.api;

import com.rlti.autoescola.servico.domain.Categoria;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class InstrutorUpdateResquest {
    @NotNull(message = "Campo Obrigatório!")
    String nomeCompleto;
    @NotNull(message = "Campo Obrigatório!")
    LocalDate validadeCnh;
    @NotNull(message = "Campo Obrigatório!")
    Categoria categoria;
}