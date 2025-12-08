package com.folha.service;

import com.folha.domain.dto.FolhaResponse;
import com.folha.domain.entity.FolhaPagamento;
import com.folha.domain.entity.Funcionario;
import com.folha.repository.FolhaPagamentoRepository;
import com.folha.repository.FuncionarioRepository;
import com.folha.service.strategy.CalculadoraFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FolhaPagamentoService {

    private final FuncionarioRepository funcionarioRepository;
    private final FolhaPagamentoRepository folhaRepository;
    private final CalculadoraFactory calculadoraFactory;
    private final ApplicationEventPublisher publisher;

    public FolhaPagamentoService(FuncionarioRepository funcionarioRepository,
                                 FolhaPagamentoRepository folhaRepository,
                                 CalculadoraFactory calculadoraFactory,
                                 ApplicationEventPublisher publisher) {
        this.funcionarioRepository = funcionarioRepository;
        this.folhaRepository = folhaRepository;
        this.calculadoraFactory = calculadoraFactory;
        this.publisher = publisher;
    }

    public FolhaResponse gerarFolha(Long funcionarioId, int mes, int ano) {
        Funcionario f = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        BigDecimal salarioHora = calculadoraFactory.get("SALARIO_HORA").calcular(f);
        BigDecimal peric = calculadoraFactory.get("PERICULOSIDADE").calcular(f);
        BigDecimal insal = calculadoraFactory.get("INSALUBRIDADE").calcular(f);
        BigDecimal inss = calculadoraFactory.get("INSS").calcular(f);
        BigDecimal irrf = calculadoraFactory.get("IRRF").calcular(f);
        BigDecimal fgts = calculadoraFactory.get("FGTS").calcular(f);
        BigDecimal vt = calculadoraFactory.get("VT").calcular(f);
        BigDecimal va = calculadoraFactory.get("VA").calcular(f);

        BigDecimal salarioBruto = f.getSalarioBase().add(peric).add(insal);
        BigDecimal descontos = inss.add(irrf).add(vt);
        BigDecimal salarioLiquido = salarioBruto.subtract(descontos);

        FolhaPagamento folha = new FolhaPagamento();
        folha.setFuncionario(f);
        folha.setMes(mes);
        folha.setAno(ano);
        folha.setSalarioHora(salarioHora);
        folha.setPericulosidade(peric);
        folha.setInsalubridade(insal);
        folha.setInss(inss);
        folha.setIrrf(irrf);
        folha.setFgts(fgts);
        folha.setVt(vt);
        folha.setVa(va);
        folha.setSalarioBruto(salarioBruto);
        folha.setSalarioLiquido(salarioLiquido);

        folhaRepository.save(folha);

        publisher.publishEvent(new com.folha.events.FolhaGeradaEvent(this, folha));

        FolhaResponse resp = new FolhaResponse();
        resp.setNomeFuncionario(f.getNome());
        resp.setMes(mes);
        resp.setAno(ano);
        resp.setSalarioBase(f.getSalarioBase());
        resp.setSalarioHora(salarioHora);
        resp.setPericulosidade(peric);
        resp.setInsalubridade(insal);
        resp.setInss(inss);
        resp.setIrrf(irrf);
        resp.setFgts(fgts);
        resp.setVt(vt);
        resp.setVa(va);
        resp.setSalarioBruto(salarioBruto);
        resp.setSalarioLiquido(salarioLiquido);
        return resp;
    }
}
