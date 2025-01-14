package com.rlti.autoescola.instrutor.application.repository;

import com.rlti.autoescola.instrutor.domain.Instrutor;

import java.util.List;
import java.util.UUID;

public interface InstrutorRepository {
    Instrutor saveInstrutor(Instrutor instrutor);
    Instrutor getInstrutor(UUID idInstrutor);
    List<Instrutor> getAllInstrutors();
}
