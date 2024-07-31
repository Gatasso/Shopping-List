package dev.galasso.marketApp.controller;

import dev.galasso.marketApp.model.ShopList;
import dev.galasso.marketApp.service.ShopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
@CrossOrigin("*")
public class ShopListController {

    @Autowired
    private ShopListService service;

    @PostMapping
    public ResponseEntity<ShopList> createNewList(@RequestBody ShopList newShopList) {
        ShopList list = service.createNewList(newShopList);
        if (list != null) {
            return ResponseEntity.status(201).body(list);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopList> alterListById(@PathVariable Integer id) {
        ShopList list = service.finishList(id);
        if (list != null) {
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListById(@PathVariable Integer id){
        service.deleteList(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping
    public ResponseEntity<List<ShopList>> getAllLists() {
        return ResponseEntity.ok(service.getAllLists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopList> getListById(@PathVariable Integer id) {
        ShopList list = service.findById(id);
        if (list != null) {
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.notFound().build();
    }
}
