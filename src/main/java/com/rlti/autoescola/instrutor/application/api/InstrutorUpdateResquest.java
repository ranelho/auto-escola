package com.rlti.autoescola.instrutor.application.api;

import com.rlti.autoescola.servico.domain.Categoria;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InstrutorUpdateResquest {
    @NotNull(message = "Campo Obrigatório!")
    String fullName;
    @NotNull(message = "Campo Obrigatório!")
    LocalDate validadeCnh;
    @NotNull(message = "Campo Obrigatório!")
    Categoria categoria;
}