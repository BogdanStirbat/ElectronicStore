package com.bstirbat.sample.electronicstore.service;

import com.bstirbat.sample.electronicstore.model.db.Item;

public interface ItemService {

    Item findById(long id);

    Item save(Item item);

    Item update(Item item);
}
