package dev.galasso.marketApp.service.impl;

import dev.galasso.marketApp.model.Item;
import dev.galasso.marketApp.repository.ItemRepository;
import dev.galasso.marketApp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository repository;

    @Override
    public Item addItemToList(Item newItem) {       // este Item vem sem o Id, e o banco entende como Insert
        return repository.save(newItem);
    }

    @Override
    public Item alterItemInList(Item item) {        // este item já vem com Id, e o banco entende como ALTER
        return repository.save(item);
    }

    @Override
    public void removeItemFromList(Integer id) {
        repository.deleteById(id);
    }
}
