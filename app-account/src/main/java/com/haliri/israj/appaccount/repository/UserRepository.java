package com.haliri.israj.appaccount.repository;

import com.haliri.israj.appcommon.AppCommonApplication;
import com.haliri.israj.appcommon.setting.Table;
import com.haliri.israj.appcommon.dto.User;
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
public class UserRepository implements BaseRepository<User> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> find(String search, Integer limit, Integer offset) {
        List<User> modelList = new ArrayList<>();

        String sql = "SELECT * FROM " + Table.USER;

        try {
            modelList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        } catch (Exception e) {
            AppCommonApplication.getLogger(this).error("Data not found cause : {}", e.getMessage());
        }

        return modelList;
    }

    @Override
    public User findById(Object parameter) {
        return null;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO " + Table.USER + " (username, birth_place, birth_date, address) " +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, new Object[]{
                user.getUsername(),
                user.getBirthPlace(),
                user.getBirthDate(),
                user.getAddress(),
        });
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE " + Table.USER + " SET username = ?, birth_place  = ?, birth_date  = ?, address  = ? WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{
                user.getUsername(),
                user.getBirthPlace(),
                user.getBirthDate(),
                user.getAddress(),
                user.getId()
        });
    }

    @Override
    public void delete(Object parameter) {
        String sql = "DELETE FROM " + Table.USER + " WHERE id = ?";

        jdbcTemplate.update(sql, new Object[]{parameter});
    }
}
