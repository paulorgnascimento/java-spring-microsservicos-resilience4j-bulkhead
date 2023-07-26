package com.paulorgnascimento.cleanarchitecture.infrastructure.config;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ResilienceConfig {

    @Bean
    public BulkheadConfig bulkheadConfig() {
        return BulkheadConfig.custom()
                .maxConcurrentCalls(1)
                .maxWaitDuration(Duration.ofSeconds(5))
                .build();
    }

    @Bean
    public Bulkhead bulkhead(BulkheadConfig config) {
        return Bulkhead.of("externalService", config);
    }
}
