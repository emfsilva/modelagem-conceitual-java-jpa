package io.github.emfsilva.curso.modelagem.conceitual.resources;

import io.github.emfsilva.curso.modelagem.conceitual.model.dtos.CategoriaDTO;
import io.github.emfsilva.curso.modelagem.conceitual.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    private final CategoriaService service;
    private final ModelMapper mapper;

    @Autowired
    public CategoriaResource(CategoriaService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(service.buscar(id), CategoriaDTO.class));
    }
}
