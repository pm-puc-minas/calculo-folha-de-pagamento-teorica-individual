package com.folha.repository;

import com.folha.domain.entity.FolhaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolhaPagamentoRepository extends JpaRepository<FolhaPagamento, Long> {
}
