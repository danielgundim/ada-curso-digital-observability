package br.com.ada.observability.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaMetrics {

    private final Counter pessoaCounter;

    @Autowired
    public PessoaMetrics(MeterRegistry registry){
        pessoaCounter = Counter.builder("pessoa_maioridade").description("Teste pessoa").register(registry);
    }

    public void incrementCustomCounter(){
        pessoaCounter.increment();
    }
}
