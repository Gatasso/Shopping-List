package dev.galasso.marketApp.repository;

import dev.galasso.marketApp.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
