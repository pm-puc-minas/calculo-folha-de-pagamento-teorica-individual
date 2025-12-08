package com.folha.service;

import com.folha.domain.dto.FuncionarioRequest;
import com.folha.domain.entity.Funcionario;
import com.folha.domain.enums.GrauInsalubridade;
import com.folha.events.FuncionarioCadastradoEvent;
import com.folha.repository.FuncionarioRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final ApplicationEventPublisher publisher;

    public FuncionarioService(FuncionarioRepository repository, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public List<Funcionario> listar() {
        return repository.findAll();
    }

    public Funcionario buscar(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public Funcionario salvar(FuncionarioRequest dto) {
        Funcionario f = new Funcionario();
        f.setNome(dto.getNome());
        f.setCpf(dto.getCpf());
        f.setSalarioBase(dto.getSalarioBase());
        f.setHorasDia(dto.getHorasDia());
        f.setDiasMes(dto.getDiasMes());
        f.setRecebePericulosidade(dto.isRecebePericulosidade());
        f.setRecebeInsalubridade(dto.isRecebeInsalubridade());
        if (dto.getGrauInsalubridade() != null && !dto.getGrauInsalubridade().isEmpty()) {
            f.setGrauInsalubridade(GrauInsalubridade.valueOf(dto.getGrauInsalubridade()));
        }
        f.setUsaValeTransporte(dto.isUsaValeTransporte());
        f.setValorVT(dto.getValorVT());
        f.setUsaValeAlimentacao(dto.isUsaValeAlimentacao());
        f.setValorVA(dto.getValorVA());

        Funcionario salvo = repository.save(f);
        publisher.publishEvent(new FuncionarioCadastradoEvent(this, salvo));
        return salvo;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
