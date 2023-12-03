package br.com.brunomartins.barber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;



    @ManyToOne // relacionamento muitos para um com Cabeleireiro
    @JoinColumn(name = "cabeleireiro_id")
    private CabeleireiroModel cabeleireiro;

    // Getters e setters
}
