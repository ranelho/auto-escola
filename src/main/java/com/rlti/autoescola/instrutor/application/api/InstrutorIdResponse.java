package com.rlti.autoescola.instrutor.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class InstrutorIdResponse {
    UUID idInstrutor;
}
