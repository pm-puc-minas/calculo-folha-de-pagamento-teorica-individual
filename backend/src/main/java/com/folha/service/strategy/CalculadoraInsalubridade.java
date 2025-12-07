package com.folha.service.strategy;

import com.folha.domain.entity.Funcionario;
import com.folha.domain.enums.GrauInsalubridade;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CalculadoraInsalubridade implements CalculadoraRegra {

    @Override
    public BigDecimal calcular(Funcionario f) {
        if (!f.isRecebeInsalubridade() || f.getGrauInsalubridade() == null) {
            return BigDecimal.ZERO;
        }
        GrauInsalubridade grau = f.getGrauInsalubridade();
        return f.getSalarioBase().multiply(BigDecimal.valueOf(grau.getPercentual()));
    }
}
