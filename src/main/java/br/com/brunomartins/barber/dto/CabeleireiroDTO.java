package br.com.brunomartins.barber.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class CabeleireiroDTO extends RepresentationModel<CabeleireiroDTO> {

    private int id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String nome;

    private List<ClienteDTO> clientes;

    public CabeleireiroDTO(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e setters

    public String getNome() {
        return this.nome;
    }
}
