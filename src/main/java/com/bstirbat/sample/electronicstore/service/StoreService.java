package com.bstirbat.sample.electronicstore.service;


import com.bstirbat.sample.electronicstore.model.db.Store;

import java.util.List;

public interface StoreService {

    Store findById(long id);

    List<Store> findByCity(String city);

    Store save(Store store);

    Store update(Store store);
}
