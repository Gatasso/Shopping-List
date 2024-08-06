package dev.galasso.marketApp.controller;

import dev.galasso.marketApp.model.Item;
import dev.galasso.marketApp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@CrossOrigin("*")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping
    public ResponseEntity<Item> addItemToList(@RequestBody Item itemToAdd) {
        Item newItem = service.addItemToList(itemToAdd);
        if (newItem != null){
            return ResponseEntity.status(201).body(newItem);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItemFromList(@PathVariable Integer id) {
        service.removeItemFromList(id);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> alterItem(@RequestBody Item item, @PathVariable Integer id) {
        item.setId(id);
        Item newItem = service.alterItemInList(item);
        if (newItem != null){
            return ResponseEntity.ok(newItem);
        }
        return ResponseEntity.badRequest().build();
    }
}
