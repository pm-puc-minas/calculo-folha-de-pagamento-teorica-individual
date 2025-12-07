package com.folha.domain.entity;

import com.folha.domain.enums.GrauInsalubridade;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private BigDecimal salarioBase;
    private int horasDia;
    private int diasMes;

    private boolean recebePericulosidade;
    private boolean recebeInsalubridade;

    @Enumerated(EnumType.STRING)
    private GrauInsalubridade grauInsalubridade;

    private boolean usaValeTransporte;
    private BigDecimal valorVT;

    private boolean usaValeAlimentacao;
    private BigDecimal valorVA;

    public Funcionario() {}

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public BigDecimal getSalarioBase() { return salarioBase; }

    public void setSalarioBase(BigDecimal salarioBase) { this.salarioBase = salarioBase; }

    public int getHorasDia() { return horasDia; }

    public void setHorasDia(int horasDia) { this.horasDia = horasDia; }

    public int getDiasMes() { return diasMes; }

    public void setDiasMes(int diasMes) { this.diasMes = diasMes; }

    public boolean isRecebePericulosidade() { return recebePericulosidade; }

    public void setRecebePericulosidade(boolean recebePericulosidade) { this.recebePericulosidade = recebePericulosidade; }

    public boolean isRecebeInsalubridade() { return recebeInsalubridade; }

    public void setRecebeInsalubridade(boolean recebeInsalubridade) { this.recebeInsalubridade = recebeInsalubridade; }

    public GrauInsalubridade getGrauInsalubridade() { return grauInsalubridade; }

    public void setGrauInsalubridade(GrauInsalubridade grauInsalubridade) { this.grauInsalubridade = grauInsalubridade; }

    public boolean isUsaValeTransporte() { return usaValeTransporte; }

    public void setUsaValeTransporte(boolean usaValeTransporte) { this.usaValeTransporte = usaValeTransporte; }

    public BigDecimal getValorVT() { return valorVT; }

    public void setValorVT(BigDecimal valorVT) { this.valorVT = valorVT; }

    public boolean isUsaValeAlimentacao() { return usaValeAlimentacao; }

    public void setUsaValeAlimentacao(boolean usaValeAlimentacao) { this.usaValeAlimentacao = usaValeAlimentacao; }

    public BigDecimal getValorVA() { return valorVA; }

    public void setValorVA(BigDecimal valorVA) { this.valorVA = valorVA; }
}
