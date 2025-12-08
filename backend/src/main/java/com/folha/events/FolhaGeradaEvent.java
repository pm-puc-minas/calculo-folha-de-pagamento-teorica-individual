package com.folha.events;

import com.folha.domain.entity.FolhaPagamento;
import org.springframework.context.ApplicationEvent;

public class FolhaGeradaEvent extends ApplicationEvent {

    private final FolhaPagamento folha;

    public FolhaGeradaEvent(Object source, FolhaPagamento folha) {
        super(source);
        this.folha = folha;
    }

    public FolhaPagamento getFolha() {
        return folha;
    }
}
