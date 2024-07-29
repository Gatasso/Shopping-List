package dev.galasso.marketApp.service;

import dev.galasso.marketApp.model.Item;

public interface ItemService {
    Item addItemToList(Item newItem);

    Item alterItemInList(Item item);

    void removeItemFromList(Integer id);
}
