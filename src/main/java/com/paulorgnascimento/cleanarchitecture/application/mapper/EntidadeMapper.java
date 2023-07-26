package com.paulorgnascimento.cleanarchitecture.application.mapper;

import com.paulorgnascimento.cleanarchitecture.application.dto.EntidadeInDto;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeMapping;
import org.springframework.stereotype.Service;

@Service
public class EntidadeMapper {

    public EntidadeMapping toEntity(Entidade entidade, AgregadoMapping agregadoMapping) {
        EntidadeMapping entidadeMapping = new EntidadeMapping();
        entidadeMapping.setCampo1(entidade.getCampo1());
        entidadeMapping.setCampo2(entidade.getCampo2());
        entidadeMapping.setCampo3(entidade.getCampo3());
        entidadeMapping.setCampo4(entidade.getCampo4());
        entidadeMapping.setCampo5(entidade.getCampo5());
        entidadeMapping.setAgregado(agregadoMapping);
        return entidadeMapping;
    }

    public Entidade dtoToDomain(EntidadeInDto dto) {
        if ( dto == null ) {
            return null;
        }

        String campo1 = null;
        String campo2 = null;
        int campo3 = 0;
        int campo4 = 0;

        campo1 = dto.getCampo1();
        campo2 = dto.getCampo2();
        campo3 = dto.getCampo3();
        campo4 = dto.getCampo4();

        Entidade entidade = new Entidade( campo1, campo2, campo3, campo4 );

        return entidade;
    }

}
