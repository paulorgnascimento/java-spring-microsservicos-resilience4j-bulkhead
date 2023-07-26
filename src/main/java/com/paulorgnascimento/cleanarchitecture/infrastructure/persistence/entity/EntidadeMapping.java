package com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "entidade")
@Data
@NoArgsConstructor
public class EntidadeMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String campo1;

    @Column
    private String campo2;

    @Column
    private int campo3;

    @Column
    private int campo4;

    @Column
    private double campo5;

    @ManyToOne
    @JoinColumn(name="agregado_id", nullable=false)
    private AgregadoMapping agregado;
}
