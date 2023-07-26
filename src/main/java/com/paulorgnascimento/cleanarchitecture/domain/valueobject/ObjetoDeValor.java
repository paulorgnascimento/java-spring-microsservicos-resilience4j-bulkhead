package com.paulorgnascimento.cleanarchitecture.domain.valueobject;

public class ObjetoDeValor {

    private String campo2vo;

    public ObjetoDeValor(String campo2vo) {
        this.campo2vo = campo2vo;
    }

    public String getCampo1() { return campo2vo; }

    // Value Objects geralmente são imutáveis e, assim, não incluem setters e não tem uma identidade única
}

