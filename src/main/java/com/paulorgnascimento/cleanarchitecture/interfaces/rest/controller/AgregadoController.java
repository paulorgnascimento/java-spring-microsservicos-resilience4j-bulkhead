package com.paulorgnascimento.cleanarchitecture.interfaces.rest.controller;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoOutDto;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.services.AgregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agregados")
public class AgregadoController {

    private final AgregadoService agregadoService;

    @Autowired
    public AgregadoController(AgregadoService agregadoService) {
        this.agregadoService = agregadoService;
    }

    @PostMapping
    public ResponseEntity<Agregado> criarAgregado(@RequestBody AgregadoInDto agregadoInDto) {
        agregadoService.criarAgregado(agregadoInDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgregadoOutDto> consultarAgregado(@PathVariable Long id) {
        AgregadoOutDto agregadoOutDto = agregadoService.consultarAgregado(id);
        if(agregadoOutDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(agregadoOutDto, HttpStatus.OK);
        }
    }
}