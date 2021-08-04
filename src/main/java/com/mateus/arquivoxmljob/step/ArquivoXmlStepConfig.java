package com.mateus.arquivoxmljob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoXmlStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step arquivoXmlStep(ItemReader reader,
                               ItemWriter writer) {
        return stepBuilderFactory
                .get("arquivoXmlStep")
                .chunk(10)
                .reader(reader)
                .writer(writer)
                .build();
    }
}
