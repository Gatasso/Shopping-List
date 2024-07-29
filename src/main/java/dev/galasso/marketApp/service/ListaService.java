package dev.galasso.marketApp.service;

import dev.galasso.marketApp.model.ShopList;

public interface ListaService {
    ShopList createNewList();

    void deleteList(Integer id);

    void finishList(Integer id);

    void findById(Integer id);
}
