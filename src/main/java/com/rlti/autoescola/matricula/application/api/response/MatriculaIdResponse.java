package com.rlti.autoescola.matricula.application.api.response;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class MatriculaIdResponse {
    UUID idMatricula;
}
