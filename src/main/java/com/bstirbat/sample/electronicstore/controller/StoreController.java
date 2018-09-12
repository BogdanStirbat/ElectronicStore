package com.bstirbat.sample.electronicstore.controller;

import com.bstirbat.sample.electronicstore.model.db.Store;
import com.bstirbat.sample.electronicstore.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired
    private StoreService storeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        logger.info("Received findById call, id: {}", id);

        Store store = storeService.findById(id);

        if (store == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(store);
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody Store store) {
        logger.info("Received save call, store: {}", store);

        store = storeService.save(store);
        return ResponseEntity.ok(store);
    }

    @PutMapping(value = "/update")
    public ResponseEntity update(@RequestBody Store store) {
        logger.info("Received update call, store: {}", store);

        store = storeService.update(store);
        return ResponseEntity.ok(store);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity remove(@PathVariable Long id) {
        logger.info("Received findById call, id: {}", id);

        Store store = storeService.findById(id);
        storeService.remove(store);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/list/{city}")
    public ResponseEntity findByCity(@PathVariable String city) {
        logger.info("Received findByCity call, city: {}", city);

        List<Store> stores = storeService.findByCity(city);
        return ResponseEntity.ok(stores);
    }
}
