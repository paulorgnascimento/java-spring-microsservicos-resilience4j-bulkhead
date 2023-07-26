package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository;

import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgregadoRepository extends JpaRepository<AgregadoMapping, Long> {
}
