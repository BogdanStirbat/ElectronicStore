package com.bstirbat.sample.electronicstore.service;

import com.bstirbat.sample.electronicstore.model.db.Item;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    private EntityManager entityManager;

    public ItemServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Item findById(long id) {
        return entityManager.find(Item.class, id);
    }

    @Override
    @Transactional
    public Item save(Item item) {
        entityManager.persist(item);
        return item;
    }

    @Override
    @Transactional
    public Item update(Item item) {
        return entityManager.merge(item);
    }
}
