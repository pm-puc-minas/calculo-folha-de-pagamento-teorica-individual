package com.folha.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FolhaEventListener {

    @EventListener
    public void aoCadastrarFuncionario(FuncionarioCadastradoEvent event) {
        System.out.println("Funcionário cadastrado: " + event.getFuncionario().getNome());
    }

    @EventListener
    public void aoGerarFolha(FolhaGeradaEvent event) {
        System.out.println("Folha gerada para: " + event.getFolha().getFuncionario().getNome());
    }
}
