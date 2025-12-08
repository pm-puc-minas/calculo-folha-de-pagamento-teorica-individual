package com.folha.service.strategy;

import com.folha.domain.entity.Funcionario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculadoraFGTS implements CalculadoraRegra {

    @Override
    public BigDecimal calcular(Funcionario f) {
        return f.getSalarioBase().multiply(BigDecimal.valueOf(0.08));
    }
}
