package com.folha.service.strategy;

import com.folha.domain.entity.Funcionario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CalculadoraSalarioHora implements CalculadoraRegra {

    @Override
    public BigDecimal calcular(Funcionario f) {
        int horasMes = f.getHorasDia() * f.getDiasMes();
        if (horasMes == 0) {
            return BigDecimal.ZERO;
        }
        return f.getSalarioBase().divide(BigDecimal.valueOf(horasMes), 2, RoundingMode.HALF_UP);
    }
}
