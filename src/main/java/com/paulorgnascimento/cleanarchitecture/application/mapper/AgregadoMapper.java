package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoOutDto;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.domain.valueobject.ObjetoDeValor;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class AgregadoMapper {
    private List<Entidade> campo1;
    private ObjetoDeValor campo2;

    public AgregadoMapping toEntity(Agregado agregado) {
        AgregadoMapping agregadoMapping = new AgregadoMapping();
        agregadoMapping.setObjetoDeValor(agregado.valueobject().getCampo1());
        return agregadoMapping;
    }

    public Agregado fromDto(AgregadoInDto dto) {
        ObjetoDeValor campo2vo = new ObjetoDeValor(dto.getCampo2());
        Agregado agregado = new Agregado(dto.getCampo1(), campo2vo);
        return agregado;
    }

    public AgregadoOutDto dataMappingToDto(AgregadoMapping agregadoMapping) {
        AgregadoOutDto dto = new AgregadoOutDto();
        dto.setId(agregadoMapping.getId());
        dto.setCampo2(agregadoMapping.getObjetoDeValor());
        return dto;
    }
}
