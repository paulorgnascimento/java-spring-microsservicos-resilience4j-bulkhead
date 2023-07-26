package com.paulorgnascimento.cleanarchitecture.infrastructure.gateway;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class IntegracaoWebClientGateway implements IntegracaoGateway {

    private final WebClient webClient;

    public IntegracaoWebClientGateway(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    @Override
    public Integracao getTodoById(int id) {
        return webClient.get()
                .uri("/todos/" + id)
                .retrieve()
                .bodyToMono(Integracao.class)
                .block();
    }
}