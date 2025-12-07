package com.folha.service.strategy;

import com.folha.domain.entity.Funcionario;
import java.math.BigDecimal;

public interface CalculadoraRegra {
    BigDecimal calcular(Funcionario f);
}
