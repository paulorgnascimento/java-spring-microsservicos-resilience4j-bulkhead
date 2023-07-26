package com.paulorgnascimento.cleanarchitecture.application.services;

import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoInDto;
import com.paulorgnascimento.cleanarchitecture.application.dto.AgregadoOutDto;
import com.paulorgnascimento.cleanarchitecture.application.mapper.AgregadoMapper;
import com.paulorgnascimento.cleanarchitecture.application.mapper.EntidadeMapper;
import com.paulorgnascimento.cleanarchitecture.domain.aggregateroot.Agregado;
import com.paulorgnascimento.cleanarchitecture.domain.entity.Entidade;
import com.paulorgnascimento.cleanarchitecture.infrastructure.gateway.Integracao;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.AgregadoMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.entity.EntidadeMapping;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.AgregadoRepository;
import com.paulorgnascimento.cleanarchitecture.infrastructure.persistence.repository.EntidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.github.resilience4j.bulkhead.Bulkhead;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class AgregadoServiceImpl implements AgregadoService {

    private final AgregadoMapper agregadoMapper;
    private final EntidadeMapper entidadeMapper;
    private final AgregadoRepository agregadoRepository;
    private final EntidadeRepository entidadeRepository;
    private final IntegracaoService integracaoService;
    private final Bulkhead bulkhead;

    public AgregadoServiceImpl(AgregadoMapper agregadoMapper,
                               EntidadeMapper entidadeMapper,
                               AgregadoRepository agregadoRepository,
                               IntegracaoService integracaoService,
                               EntidadeRepository entidadeRepository,
                               Bulkhead bulkhead) {
        this.agregadoMapper = agregadoMapper;
        this.entidadeMapper = entidadeMapper;
        this.agregadoRepository = agregadoRepository;
        this.integracaoService = integracaoService;
        this.entidadeRepository = entidadeRepository;
        this.bulkhead = bulkhead;
    }

    @Override
    @Transactional
    public void criarAgregado(AgregadoInDto agregadoInDto) {
        try {
            Supplier<Integracao> supplier = Bulkhead.decorateSupplier(bulkhead,
                    () -> integracaoService.execute(1));

            Integracao integracao = supplier.get();
            Agregado agregado = agregadoMapper.fromDto(agregadoInDto);
            AgregadoMapping agregadoMapping = agregadoMapper.toEntity(agregado);
            agregadoRepository.save(agregadoMapping);
            salvarEntidades(agregadoInDto, agregadoMapping);
        } catch (Exception e) {
            // Tratar exceção
        }
    }

    private void salvarEntidades(AgregadoInDto agregadoInDto, AgregadoMapping agregadoMapping) {
        for (Entidade entidade : agregadoInDto.getCampo1()) {
            EntidadeMapping entidadeMapping = entidadeMapper.toEntity(entidade, agregadoMapping);
            entidadeRepository.save(entidadeMapping);
        }
    }

    @Override
    public AgregadoOutDto consultarAgregado(Long id) {
        Optional<AgregadoMapping> agregadoMappingOptional = agregadoRepository.findById(id);
        return agregadoMappingOptional.map(agregadoMapper::dataMappingToDto).orElse(null);
    }
}
