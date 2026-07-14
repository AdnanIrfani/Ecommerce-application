package com.ecommerce.demo.Service;

import com.ecommerce.demo.Entity.Items;
import com.ecommerce.demo.Repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Items addItem(Items item){
        return itemRepository.save(item);
    }
    public List<Items> getAllItems(){
        return itemRepository.findAll();
    }

    public Items getItemById(Long id){
        return itemRepository.findById(id).orElseThrow(()->new RuntimeException("Item not found"));
    }

    public Items updateItem(Long id, Items item){
        Items item1 = itemRepository.findById(id).orElse(null);
        if(item1 != null) {
            item1.setItem_name(item.getItem_name());
            item1.setItem_category(item.getItem_category());
            item1.setItem_desc(item.getItem_desc());
            item1.setItem_desc(item.getItem_desc());
            item1.setPrice(item.getPrice());
            item1.setStock(item.getStock());

            return itemRepository.save(item1);
        }
        return null;
    }

    public Items deleteItem(Long id){
        Items item = itemRepository.findById(id).orElse(null);
        if(item != null) {
            itemRepository.delete(item);
            return item;
        }
        return null;
    }
}
