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
//        List<Item> items = entityManager.createQuery("select i from Item i where i.id=:id", Item.class)
//                .setParameter("id", id)
//                .getResultList();
//
//        if (items == null || items.isEmpty()) {
//            return null;
//        }
//
//        return items.get(0);
    }

    @Override
    @Transactional
    public Item save(Item item) {
        entityManager.persist(item);
        return item;
    }
}
