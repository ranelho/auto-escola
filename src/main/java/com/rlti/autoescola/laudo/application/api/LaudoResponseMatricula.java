package com.rlti.autoescola.laudo.application.api;

import lombok.Data;

import java.util.UUID;

@Data
public class LaudoResponseMatricula {
    UUID idMatricula;
    String fullName;
}
