package com.bstirbat.sample.electronicstore;

import com.bstirbat.sample.electronicstore.service.ItemService;
import com.bstirbat.sample.electronicstore.service.ItemServiceImpl;
import com.bstirbat.sample.electronicstore.service.StoreService;
import com.bstirbat.sample.electronicstore.service.StoreServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class AppConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public StoreService storeService() {
        return new StoreServiceImpl(entityManager);
    }

    @Bean
    public ItemService itemService() {
        return new ItemServiceImpl(entityManager);
    }
}
