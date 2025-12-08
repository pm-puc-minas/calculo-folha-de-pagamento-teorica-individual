package com.folha.service.strategy;

import com.folha.domain.entity.Funcionario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculadoraVT implements CalculadoraRegra {

    @Override
    public BigDecimal calcular(Funcionario f) {
        if (!f.isUsaValeTransporte()) {
            return BigDecimal.ZERO;
        }
        // desconto máximo de 6% do salário
        return f.getSalarioBase().multiply(BigDecimal.valueOf(0.06));
    }
}
