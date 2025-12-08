package com.folha;

import com.folha.domain.entity.Funcionario;
import com.folha.service.strategy.CalculadoraINSS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CalculadoraINSSTest {

    private final CalculadoraINSS calculadora = new CalculadoraINSS();

    @Test
    void testeFaixaBaixa() {
        Funcionario f = new Funcionario();
        f.setSalarioBase(BigDecimal.valueOf(1200.00));
        BigDecimal resultado = calculadora.calcular(f);
        Assertions.assertEquals(BigDecimal.valueOf(1200.00).multiply(BigDecimal.valueOf(0.075)), resultado);
    }
}
