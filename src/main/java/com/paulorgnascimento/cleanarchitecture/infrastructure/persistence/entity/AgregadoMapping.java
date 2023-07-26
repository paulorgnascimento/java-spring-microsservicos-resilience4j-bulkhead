package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agregado")
@Data
@NoArgsConstructor
public class AgregadoMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String objetoDeValor;

    @OneToMany(mappedBy = "agregado")
    private List<EntidadeMapping> entidades;
}
