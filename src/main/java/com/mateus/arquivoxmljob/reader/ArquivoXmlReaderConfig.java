package com.mateus.arquivoxmljob.reader;

import com.mateus.arquivoxmljob.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ArquivoXmlReaderConfig {

    @Bean
    @StepScope
    public StaxEventItemReader itemReader(@Value("#{jobParameters['arquivoClientes']}")
                                                  Resource arquivoClientes) {
        return new StaxEventItemReaderBuilder<Cliente>()
                .name("itemReader")
                .resource(arquivoClientes)
                .addFragmentRootElements("cliente")
                .unmarshaller(clienteMarshaller())
                .build();
    }

    @Bean
    public XStreamMarshaller clienteMarshaller() {
        Map<String, Class> aliases = new HashMap<>();
        aliases.put("cliente", Cliente.class);
        aliases.put("nome", String.class);
        aliases.put("sobrenome", String.class);
        aliases.put("idade", String.class);
        aliases.put("email", String.class);

        XStreamMarshaller marshaller = new XStreamMarshaller();

        marshaller.setAliases(aliases);

        return marshaller;
    }
}
