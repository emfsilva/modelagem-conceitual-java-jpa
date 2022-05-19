package io.github.emfsilva.curso.modelagem.conceitual.resources;

import io.github.emfsilva.curso.modelagem.conceitual.model.dtos.PedidoDTO;
import io.github.emfsilva.curso.modelagem.conceitual.model.dtos.ProdutoDTO;
import io.github.emfsilva.curso.modelagem.conceitual.services.PedidoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    private final PedidoService pedidoService;
    private final ModelMapper mapper;

    @Autowired
    public PedidoResource(PedidoService pedidoService, ModelMapper mapper) {
        this.pedidoService = pedidoService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(pedidoService.buscar(id), PedidoDTO.class));
    }
}
