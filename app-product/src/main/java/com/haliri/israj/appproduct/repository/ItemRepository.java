package com.haliri.israj.appproduct.repository;

import com.haliri.israj.appcommon.AppCommonApplication;
import com.haliri.israj.appcommon.dto.Item;
import com.haliri.israj.appcommon.dto.Item;
import com.haliri.israj.appcommon.setting.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by israjHaliri
 */
@Repository
public class ItemRepository implements BaseRepository<Item> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Cacheable(cacheNames = "item")
    @Override
    public List<Item> find(String search, Integer limit, Integer offset) {
        List<Item> modelList = new ArrayList<>();

        String sql = "SELECT * FROM " + Table.ITEM;

        try {
            modelList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Item.class));
        } catch (Exception e) {
            AppCommonApplication.getLogger(this).error("Data not found cause : {}", e.getMessage());
        }

        return modelList;
    }

    @Override
    public Item findById(Object parameter) {
        Item model = new Item();

        String sql = "SELECT * FROM " + Table.ITEM + " WHERE id = ?";

        try {
            model = jdbcTemplate.queryForObject(sql, new Object[]{parameter}, new BeanPropertyRowMapper<>(Item.class));
        } catch (Exception e) {
            AppCommonApplication.getLogger(this).error("Data not found cause : {}", e.getMessage());
        }

        return model;
    }

    @Override
    public Item save(Item item) {
        String sql = "INSERT INTO " + Table.ITEM + " (title, description, amount, price) " +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, new Object[]{
                item.getTitle(),
                item.getDescription(),
                item.getAmount(),
                item.getPrice(),
        });

        return item;
    }

    @CachePut(cacheNames = "item", key = "#item.id()")
    @Override
    public Item update(Item item) {
        String sql = "UPDATE " + Table.ITEM + " SET title = ?, description  = ?, amount  = ?, price  = ? WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{
                item.getTitle(),
                item.getDescription(),
                item.getAmount(),
                item.getPrice(),
                item.getId()
        });

        return item;
    }

    @CachePut(cacheNames = "item", key = "#id")
    public void updateAmount(Integer id) {
        String sql = "UPDATE " + Table.ITEM + " SET amount = amount - 1 WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{
                id
        });
    }

    @CacheEvict(cacheNames = "item", allEntries=true)
    @Override
    public void delete(Object parameter) {
        String sql = "DELETE FROM " + Table.ITEM + " WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{parameter});
    }
}
