package com.ecommerce.demo.Controller;

import com.ecommerce.demo.Entity.Items;
import com.ecommerce.demo.Service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Items addItem(@RequestBody Items item){
        return itemService.addItem(item);
    }

    @GetMapping
    public List<Items> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Items getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }

    @PutMapping("/{id}")
    public Items updateItem(@PathVariable Long id,@RequestBody Items item){
        return itemService.updateItem(id,item);
    }

    @DeleteMapping("/{id}")
    public Items deleteItem(@PathVariable Long id){
        return itemService.deleteItem(id);
    }
}
