package com.devnaldo.devnaldo_log.domain.repository;

import com.devnaldo.devnaldo_log.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
