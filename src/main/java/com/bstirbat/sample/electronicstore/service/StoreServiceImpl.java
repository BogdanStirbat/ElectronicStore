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
        return entityManager.find(Store.class, id);
    }

    @Override
    public List<Store> findByCity(String city) {
        return entityManager.createQuery("select s from Store s where s.city=:city", Store.class)
                .setParameter("city", city)
                .setHint("org.hibernate.cacheable", true)
                .getResultList();
    }

    @Override
    @Transactional
    public Store save(Store store) {
        entityManager.persist(store);
        return store;
    }

    @Override
    @Transactional
    public Store update(Store store) {
        return entityManager.merge(store);
    }
}
