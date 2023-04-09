package com.rlti.autoescola.instrutor.application.api;

import com.rlti.autoescola.servico.domain.Categoria;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class InstrutorUpdateResquest {
    @NotBlank(message = "Campo Obrigatório!")
    String nomeCompleto;
    @NotBlank(message = "Campo Obrigatório!")
    LocalDate validadeCnh;
    @NotBlank(message = "Campo Obrigatório!")
    Categoria categoria;
}