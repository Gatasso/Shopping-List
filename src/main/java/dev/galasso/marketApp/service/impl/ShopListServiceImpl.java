package dev.galasso.marketApp.service.impl;

import dev.galasso.marketApp.model.Item;
import dev.galasso.marketApp.model.ShopList;
import dev.galasso.marketApp.repository.ShopListRepository;
import dev.galasso.marketApp.service.ShopListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopListServiceImpl implements ShopListService {

    @Autowired
    private ShopListRepository repository;

    @Override
    public ShopList createNewList(ShopList newShopList) {
        return (repository.save(newShopList));
    }

    @Override
    public void deleteList(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ShopList finishList(Integer id) {
        ShopList list = repository.findById(id).get();
        double total = 0.0;
        for(Item itens : list.getItens()){
            total += list.getTotalPrice();
        }
        list.setTotalPrice(total);
        list.setStatus(1);  // lista concuída
        return repository.save(list);
    }

    @Override
    public ShopList findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
