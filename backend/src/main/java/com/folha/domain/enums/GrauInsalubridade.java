package com.folha.domain.enums;

public enum GrauInsalubridade {
    MINIMO(0.10),
    MEDIO(0.20),
    MAXIMO(0.40);

    private final double percentual;

    GrauInsalubridade(double percentual) {
        this.percentual = percentual;
    }

    public double getPercentual() {
        return percentual;
    }
}
