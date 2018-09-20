package com.haliri.israj.appproduct.controller;

import com.haliri.israj.appcommon.dto.Item;
import com.haliri.israj.appproduct.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<Item> find() {
        return itemService.find();
    }

    @GetMapping("/find-by-id/{id}")
    public Item findById(@PathVariable("id") Object id) {
        return itemService.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Item item) {
        itemService.save(item);
    }

    @PutMapping("/update-amount")
    public void updateAmount(@RequestParam("id") Integer id) {
        itemService.updateAmount(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Item item) {
        itemService.update(item);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Integer id) {
        itemService.delete(id);
    }
}
