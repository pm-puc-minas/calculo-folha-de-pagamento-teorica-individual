package com.folha.events;

import com.folha.domain.entity.Funcionario;
import org.springframework.context.ApplicationEvent;

public class FuncionarioCadastradoEvent extends ApplicationEvent {

    private final Funcionario funcionario;

    public FuncionarioCadastradoEvent(Object source, Funcionario funcionario) {
        super(source);
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
}
