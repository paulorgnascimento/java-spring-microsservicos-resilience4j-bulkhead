package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Integracao;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.IntegracaoGateway;
import org.springframework.stereotype.Service;

@Service
public class IntegracaoService {

    private IntegracaoGateway integracaoGateway;

    public IntegracaoService(IntegracaoGateway integracaoGateway) {
        this.integracaoGateway = integracaoGateway;
    }

    public Integracao execute(int id) {
        return integracaoGateway.getTodoById(id);
    }
}