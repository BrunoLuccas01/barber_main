package br.com.brunomartins.barber.controller;

import br.com.brunomartins.barber.dto.CabeleireiroDTO;
import br.com.brunomartins.barber.model.ClienteModel;
import br.com.brunomartins.barber.service.CabeleireiroService;
import br.com.brunomartins.barber.dto.ClienteDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/cabeleireiros")
@Tag(name = "Cabeleireiros", description = "Este endpoint gerencia os Cabeleireiros")
public class CabeleireiroController {

    @Autowired
    private CabeleireiroService service;

    @PostMapping
    @Operation(summary = "Cria um novo cabeleireiro no banco de dados", tags = {"Cabeleireiros"}, responses = {
            @ApiResponse(description = "Sucesso!", responseCode = "200", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CabeleireiroDTO.class))
            })
    })
    public CabeleireiroDTO create(@RequestBody CabeleireiroDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontra um cabeleireiro pelo ID", tags = {"Cabeleireiros"}, responses = {
            @ApiResponse(description = "Sucesso!", responseCode = "200", content = {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = CabeleireiroDTO.class)
                    )
            }),
            @ApiResponse(description = "Requisição Inválida", responseCode = "400", content = {@Content}),
            @ApiResponse(description = "Não Autorizado", responseCode = "401", content = {@Content}),
            @ApiResponse(description = "Erro Interno", responseCode = "500", content = {@Content})
    })
    public CabeleireiroDTO findById(@PathVariable("id") int id) {
        CabeleireiroDTO dto = service.findById(id);
        // links HATEOAS
        buildEntityLink(dto);
        return dto;
    }

    @GetMapping
    public ResponseEntity<PagedModel<CabeleireiroDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            PagedResourcesAssembler<CabeleireiroDTO> assembler
    ) {
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "nome"));

        Page<CabeleireiroDTO> cabeleireiros = service.findAll(pageable);

        for (CabeleireiroDTO cabeleireiro : cabeleireiros) {
            buildEntityLink(cabeleireiro);
        }
        return new ResponseEntity(assembler.toModel(cabeleireiros), HttpStatus.OK);
    }

//    @GetMapping("/{id}/clientes")
//    public ResponseEntity<List<ClienteModel>> getClientesByCabeleireiro(@PathVariable("id") int id) {
//        List<ClienteModel> clientes = service.getClientesByCabeleireiro(id);
//        return new ResponseEntity<>(clientes, HttpStatus.OK);  
//    }

    @PostMapping("/{id}/clientes")
    public ResponseEntity<ClienteDTO> createCliente(@PathVariable("id") int id, @RequestBody ClienteDTO dto) {
        ClienteDTO createdCliente = service.createCliente(id, dto);
        return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
    }

    @PutMapping
    public CabeleireiroDTO update(@RequestBody CabeleireiroDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        CabeleireiroDTO dto = service.findById(id);
        service.delete(dto);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public void buildEntityLink(CabeleireiroDTO cabeleireiro) {
        // links HATEOAS
        cabeleireiro.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).findById(cabeleireiro.getId())
                ).withSelfRel()
        );
    }
}
