package com.rlti.autoescola.frota.veiculo.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class VeiculoIdResponse {
    UUID idVeiculo;
}
