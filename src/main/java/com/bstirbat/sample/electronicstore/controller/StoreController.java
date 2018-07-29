package com.bstirbat.sample.electronicstore.controller;

import com.bstirbat.sample.electronicstore.model.db.Store;
import com.bstirbat.sample.electronicstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        Store store = storeService.findById(id);

        if (store == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(store);
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody Store store) {
        store = storeService.save(store);
        return ResponseEntity.ok(store);
    }
}
