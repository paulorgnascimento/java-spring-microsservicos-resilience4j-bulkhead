package com.paulorgnascimento.cleanarchitecture.domain.entity;

public class Entidade {
    private String campo1;
    private String campo2;
    private int campo3;
    private int campo4;
    private double campo5;

    public Entidade(String campo1, String campo2, int campo3, int campo4) {
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.campo3 = campo3;
        this.campo4 = campo4;

        algoritmoCampo5(campo3, campo4);
    }

    public String getCampo1() {
        return campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public int getCampo3() {
        return campo3;
    }

    public int getCampo4() {
        return campo4;
    }

    public double getCampo5() {
        return campo5;
    }

    public void algoritmoCampo5(int campo3, int campo4) {
        this.campo5 = Math.sqrt(Math.pow(campo3, 2) + Math.pow(campo4, 2));;
    }
}
