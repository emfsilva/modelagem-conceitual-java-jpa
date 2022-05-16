package io.github.emfsilva.curso.modelagem.conceitual.repositories;

import io.github.emfsilva.curso.modelagem.conceitual.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
