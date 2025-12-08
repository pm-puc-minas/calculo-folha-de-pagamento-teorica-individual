package com.folha.controller;

import com.folha.domain.dto.FolhaResponse;
import com.folha.service.FolhaPagamentoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/folha")
@CrossOrigin(origins = "*")
public class FolhaController {

    private final FolhaPagamentoService service;

    public FolhaController(FolhaPagamentoService service) {
        this.service = service;
    }

    @PostMapping("/gerar")
    public FolhaResponse gerarFolha(
            @RequestParam Long funcionarioId,
            @RequestParam int mes,
            @RequestParam int ano) {
        return service.gerarFolha(funcionarioId, mes, ano);
    }
}
