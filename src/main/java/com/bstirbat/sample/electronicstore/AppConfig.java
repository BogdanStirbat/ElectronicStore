package com.bstirbat.sample.electronicstore;

import com.bstirbat.sample.electronicstore.service.MessageService;
import com.bstirbat.sample.electronicstore.service.MessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MessageService messageService() {
        return new MessageServiceImpl();
    }
}
