package io.github.emfsilva.curso.modelagem.conceitual.resources;

import io.github.emfsilva.curso.modelagem.conceitual.model.dtos.ClienteDTO;
import io.github.emfsilva.curso.modelagem.conceitual.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    private final ClienteService clienteService;
    private final ModelMapper mapper;

    @Autowired
    public ClienteResource(ClienteService clienteService, ModelMapper mapper) {
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(clienteService.buscar(id), ClienteDTO.class));
    }
}
