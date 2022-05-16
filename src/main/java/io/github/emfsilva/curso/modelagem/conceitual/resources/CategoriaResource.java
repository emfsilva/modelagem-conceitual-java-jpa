package io.github.emfsilva.curso.modelagem.conceitual.resources;

import io.github.emfsilva.curso.modelagem.conceitual.model.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @GetMapping
    public List<Categoria> listar() {
        Categoria cat1 = new Categoria(1, "Informatica");
        Categoria cat12 = new Categoria(2, "Escritorio");
        List<Categoria> lista = new ArrayList<>();
        lista.add(cat1);
        lista.add(cat12);
        return lista;
    }
}
