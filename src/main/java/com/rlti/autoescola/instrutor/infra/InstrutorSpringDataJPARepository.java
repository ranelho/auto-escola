package com.rlti.autoescola.instrutor.infra;

import com.rlti.autoescola.instrutor.domain.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstrutorSpringDataJPARepository extends JpaRepository<Instrutor, UUID> {
}
