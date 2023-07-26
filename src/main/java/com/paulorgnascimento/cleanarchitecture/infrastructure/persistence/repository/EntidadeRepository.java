package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository;

import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadeRepository extends JpaRepository<EntidadeMapping, Long> {
}