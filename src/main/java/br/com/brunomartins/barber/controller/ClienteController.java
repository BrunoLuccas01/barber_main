package br.com.brunomartins.barber.controller;

import br.com.brunomartins.barber.dto.ClienteDTO;
import br.com.brunomartins.barber.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes") // Atualizando o caminho da API para "clientes"
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ClienteDTO create(@RequestBody ClienteDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ClienteDTO> findAll() {
        return service.findAll();
    }

    @PutMapping
    public ClienteDTO update(@RequestBody ClienteDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
