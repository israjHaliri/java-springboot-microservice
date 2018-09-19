package com.haliri.israj.apporder.repository;

import com.haliri.israj.appcommon.AppCommonApplication;
import com.haliri.israj.appcommon.dto.Item;
import com.haliri.israj.appcommon.dto.Request;
import com.haliri.israj.appcommon.dto.User;
import com.haliri.israj.appcommon.setting.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by israjHaliri
 */
@Repository
public class RequestRepository implements BaseRepository<Request> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Request> find(String search, Integer limit, Integer offset) {
        List<Request> modelList = new ArrayList<>();

        String sql = "SELECT * FROM " + Table.REQUEST;

        try {
            modelList = jdbcTemplate.query(sql, (resultSet, i) -> {
                Request model = new Request();
                model.setId(resultSet.getInt("id"));
                model.setItem(new Item(resultSet.getInt("item_id")));
                model.setUser(new User(resultSet.getInt("user_id")));

                return model;
            });
        } catch (Exception e) {
            AppCommonApplication.getLogger(this).error("Data not found cause : {}", e.getMessage());
        }

        return modelList;
    }

    @Override
    public Request findById(Object parameter) {
        return null;
    }

    @Override
    public void save(Request request) {
        String sql = "INSERT INTO " + Table.REQUEST + " (item_id, user_id) " +
                "VALUES (?, ?)";

        jdbcTemplate.update(sql, new Object[]{
                request.getItem().getId(),
                request.getUser().getId()
        });
    }

    @Override
    public void update(Request request) {
        String sql = "UPDATE " + Table.REQUEST + " SET item_id = ?, user_id  = ? WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{
                request.getItem().getId(),
                request.getUser().getId(),
                request.getId()
        });
    }

    @Override
    public void delete(Object parameter) {
        String sql = "DELETE FROM " + Table.REQUEST + " WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{parameter});
    }
}
