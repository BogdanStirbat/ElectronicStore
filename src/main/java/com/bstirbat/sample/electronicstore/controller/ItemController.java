package com.bstirbat.sample.electronicstore.controller;

import com.bstirbat.sample.electronicstore.model.db.Item;
import com.bstirbat.sample.electronicstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        Item item = itemService.findById(id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(item);
    }

    @PostMapping(value = "/save")
    public ResponseEntity save(@RequestBody Item item) {
        item = itemService.save(item);
        return ResponseEntity.ok(item);
    }

    @PutMapping(value = "/update")
    public ResponseEntity update(@RequestBody Item item) {
        item = itemService.update(item);
        return ResponseEntity.ok(item);
    }
}
