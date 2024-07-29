package dev.galasso.marketApp.service;

import dev.galasso.marketApp.model.ShopList;

import java.util.List;

public interface ShopListService {
    ShopList createNewList(ShopList newShopList);

    void deleteList(Integer id);

    ShopList finishList(Integer id);

    ShopList findById(Integer id);

    List<ShopList> getAllLists();
}
