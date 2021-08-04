package com.mateus.arquivoxmljob.writer;

import com.mateus.arquivoxmljob.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoXmlWriterConfig {

    @Bean
    public ItemWriter<Cliente> arquivoXmlWriter() {
        return items -> items.forEach(System.out::println);
    }
}
