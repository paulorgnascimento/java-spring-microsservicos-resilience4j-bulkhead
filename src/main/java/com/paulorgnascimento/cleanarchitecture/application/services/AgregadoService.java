package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoOutDto;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;

public interface AgregadoService {
    void criarAgregado(AgregadoInDto agregadoInDto);
    AgregadoOutDto consultarAgregado(Long id);
}
