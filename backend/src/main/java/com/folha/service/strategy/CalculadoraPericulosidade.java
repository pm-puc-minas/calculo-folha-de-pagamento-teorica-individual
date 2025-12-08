package com.folha.service.strategy;

import com.folha.domain.entity.Funcionario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculadoraPericulosidade implements CalculadoraRegra {

    @Override
    public BigDecimal calcular(Funcionario f) {
        if (!f.isRecebePericulosidade()) {
            return BigDecimal.ZERO;
        }
        return f.getSalarioBase().multiply(BigDecimal.valueOf(0.30));
    }
}
