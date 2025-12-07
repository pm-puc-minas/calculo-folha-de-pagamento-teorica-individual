package com.folha.service.strategy;

import com.folha.domain.entity.Funcionario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculadoraINSS implements CalculadoraRegra {

    @Override
    public BigDecimal calcular(Funcionario f) {
        BigDecimal s = f.getSalarioBase();

        if (s.compareTo(BigDecimal.valueOf(1320.00)) <= 0)
            return s.multiply(BigDecimal.valueOf(0.075));

        if (s.compareTo(BigDecimal.valueOf(2571.29)) <= 0)
            return s.multiply(BigDecimal.valueOf(0.09));

        if (s.compareTo(BigDecimal.valueOf(3856.94)) <= 0)
            return s.multiply(BigDecimal.valueOf(0.12));

        return s.multiply(BigDecimal.valueOf(0.14));
    }
}
