package com.folha.service.strategy;

import com.folha.domain.entity.Funcionario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculadoraVA implements CalculadoraRegra {

    @Override
    public BigDecimal calcular(Funcionario f) {
        if (!f.isUsaValeAlimentacao() || f.getValorVA() == null) {
            return BigDecimal.ZERO;
        }
        return f.getValorVA();
    }
}
