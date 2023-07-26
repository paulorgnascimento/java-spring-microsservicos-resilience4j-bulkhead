package com.paulorgnascimento.cleanarchitecture.application.dto;

import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AgregadoInDto {

    private List<Entidade> campo1;
    private String campo2;

}