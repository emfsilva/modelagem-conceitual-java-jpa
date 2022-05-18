package io.github.emfsilva.curso.modelagem.conceitual.repositories;

import ch.qos.logback.core.net.server.Client;
import io.github.emfsilva.curso.modelagem.conceitual.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
