package com.rlti.autoescola.empresa.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class EmpresaResponse {
    UUID idEmpresa;
}
