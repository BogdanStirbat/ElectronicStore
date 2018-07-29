package com.bstirbat.sample.electronicstore.service;

import com.bstirbat.sample.electronicstore.model.db.Store;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class StoreServiceImpl implements StoreService {

    private EntityManager entityManager;

    public StoreServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Store findById(long id) {
        List<Store> stores = entityManager.createQuery("select s from Store s where s.id=:id", Store.class)
                .setParameter("id", id)
                .getResultList();

        if (stores == null || stores.isEmpty()) {
            return null;
        }

        return stores.get(0);
    }

    @Override
    public List<Store> findByCity(String city) {
        return entityManager.createQuery("select s from Store s where s.city=:city", Store.class)
                .setParameter("city", city)
                .getResultList();
    }

    @Override
    @Transactional
    public Store save(Store store) {
        entityManager.persist(store);
        entityManager.flush();
        return store;
    }
}
