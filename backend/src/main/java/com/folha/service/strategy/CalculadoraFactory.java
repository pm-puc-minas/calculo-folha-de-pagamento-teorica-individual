package com.folha.service.strategy;

import org.springframework.stereotype.Component;

@Component
public class CalculadoraFactory {

    private final CalculadoraSalarioHora salarioHora;
    private final CalculadoraPericulosidade periculosidade;
    private final CalculadoraInsalubridade insalubridade;
    private final CalculadoraINSS inss;
    private final CalculadoraIRRF irrf;
    private final CalculadoraFGTS fgts;
    private final CalculadoraVT vt;
    private final CalculadoraVA va;

    public CalculadoraFactory(
            CalculadoraSalarioHora salarioHora,
            CalculadoraPericulosidade periculosidade,
            CalculadoraInsalubridade insalubridade,
            CalculadoraINSS inss,
            CalculadoraIRRF irrf,
            CalculadoraFGTS fgts,
            CalculadoraVT vt,
            CalculadoraVA va) {
        this.salarioHora = salarioHora;
        this.periculosidade = periculosidade;
        this.insalubridade = insalubridade;
        this.inss = inss;
        this.irrf = irrf;
        this.fgts = fgts;
        this.vt = vt;
        this.va = va;
    }

    public CalculadoraRegra get(String nome) {
        return switch (nome) {
            case "SALARIO_HORA" -> salarioHora;
            case "PERICULOSIDADE" -> periculosidade;
            case "INSALUBRIDADE" -> insalubridade;
            case "INSS" -> inss;
            case "IRRF" -> irrf;
            case "FGTS" -> fgts;
            case "VT" -> vt;
            case "VA" -> va;
            default -> throw new IllegalArgumentException("Regra desconhecida: " + nome);
        };
    }
}
