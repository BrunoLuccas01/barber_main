package br.com.brunomartins.barber.dto;

import br.com.brunomartins.barber.model.CabeleireiroModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClienteDTO {
    private int id;
    private String nome;
    private int cabeleireiroId;

    public ClienteDTO(int id, String nome) {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCabeleireiroIdAndNome(CabeleireiroModel cabeleireiro) {
        this.cabeleireiroId = cabeleireiro.getId();
        this.nome = cabeleireiro.getNome();
    }
}
