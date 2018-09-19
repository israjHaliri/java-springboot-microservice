package com.haliri.israj.appproduct.service;

import com.haliri.israj.appcommon.dto.Item;
import com.haliri.israj.appproduct.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> find(){
        return itemRepository.find(null, null, null);
    }

    public Item findById(Object parameter){
        return itemRepository.findById(parameter);
    }

    @Transactional
    public void save(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void updateAmount(Integer id){
        itemRepository.updateAmount(id);
    }
}
