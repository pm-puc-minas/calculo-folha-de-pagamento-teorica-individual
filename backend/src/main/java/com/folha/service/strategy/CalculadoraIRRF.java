package com.folha.service.strategy;

import com.folha.domain.entity.Funcionario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculadoraIRRF implements CalculadoraRegra {

    @Override
    public BigDecimal calcular(Funcionario f) {
        BigDecimal base = f.getSalarioBase();

        if (base.compareTo(BigDecimal.valueOf(1903.98)) <= 0)
            return BigDecimal.ZERO;

        if (base.compareTo(BigDecimal.valueOf(2826.65)) <= 0)
            return base.multiply(BigDecimal.valueOf(0.075));

        if (base.compareTo(BigDecimal.valueOf(3751.05)) <= 0)
            return base.multiply(BigDecimal.valueOf(0.15));

        if (base.compareTo(BigDecimal.valueOf(4664.68)) <= 0)
            return base.multiply(BigDecimal.valueOf(0.225));

        return base.multiply(BigDecimal.valueOf(0.275));
    }
}
