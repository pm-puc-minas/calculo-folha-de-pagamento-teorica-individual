package com.folha.domain.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class FolhaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Funcionario funcionario;

    private int mes;
    private int ano;

    private BigDecimal salarioHora;
    private BigDecimal periculosidade;
    private BigDecimal insalubridade;
    private BigDecimal inss;
    private BigDecimal irrf;
    private BigDecimal fgts;
    private BigDecimal vt;
    private BigDecimal va;

    private BigDecimal salarioBruto;
    private BigDecimal salarioLiquido;

    public FolhaPagamento() {}

    public Long getId() { return id; }

    public Funcionario getFuncionario() { return funcionario; }

    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }

    public int getMes() { return mes; }

    public void setMes(int mes) { this.mes = mes; }

    public int getAno() { return ano; }

    public void setAno(int ano) { this.ano = ano; }

    public BigDecimal getSalarioHora() { return salarioHora; }

    public void setSalarioHora(BigDecimal salarioHora) { this.salarioHora = salarioHora; }

    public BigDecimal getPericulosidade() { return periculosidade; }

    public void setPericulosidade(BigDecimal periculosidade) { this.periculosidade = periculosidade; }

    public BigDecimal getInsalubridade() { return insalubridade; }

    public void setInsalubridade(BigDecimal insalubridade) { this.insalubridade = insalubridade; }

    public BigDecimal getInss() { return inss; }

    public void setInss(BigDecimal inss) { this.inss = inss; }

    public BigDecimal getIrrf() { return irrf; }

    public void setIrrf(BigDecimal irrf) { this.irrf = irrf; }

    public BigDecimal getFgts() { return fgts; }

    public void setFgts(BigDecimal fgts) { this.fgts = fgts; }

    public BigDecimal getVt() { return vt; }

    public void setVt(BigDecimal vt) { this.vt = vt; }

    public BigDecimal getVa() { return va; }

    public void setVa(BigDecimal va) { this.va = va; }

    public BigDecimal getSalarioBruto() { return salarioBruto; }

    public void setSalarioBruto(BigDecimal salarioBruto) { this.salarioBruto = salarioBruto; }

    public BigDecimal getSalarioLiquido() { return salarioLiquido; }

    public void setSalarioLiquido(BigDecimal salarioLiquido) { this.salarioLiquido = salarioLiquido; }
}
