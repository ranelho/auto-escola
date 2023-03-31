package com.rlti.autoescola.servico.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class ServicoIdResponse {
    UUID idServico;
}
