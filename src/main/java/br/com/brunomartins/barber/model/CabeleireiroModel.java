package br.com.brunomartins.barber.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cabeleireiros")
@Getter
@Setter
public class CabeleireiroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

//    @OneToMany(mappedBy = "cabeleireiro", cascade = CascadeType.ALL)
//    private List<ClienteModel> clientes;

    // Construtores, getters e setters
}
