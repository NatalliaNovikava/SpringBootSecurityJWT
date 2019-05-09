package com.example.spring.boot.app.controller;

import com.example.spring.boot.app.entity.Item;
import com.example.spring.boot.app.repository.ItemRepository;
import com.example.spring.boot.app.exception.ItemNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/items")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @PostMapping
    public void addItem(@RequestBody Item item) {
        itemRepository.save(item);
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/{id}")
    public void updateItem(@RequestBody Item newItem, @PathVariable Long id) {
        itemRepository.findById(id)
            .map(item -> {
                item.setDescription(newItem.getDescription());
                return itemRepository.save(item);
            })
            .orElseGet(() -> {
                newItem.setId(id);
                return itemRepository.save(newItem);
            });
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }

}
