package com.example.crypto_trading_sim.repositories;

import com.example.crypto_trading_sim.entities.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserRepository implements DbObjectRepository<User> {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(User user) {
        jdbcTemplate.update(
            "INSERT INTO Users (id, username, email, password) VALUES (?, ?, ?, ?)",
            user.getId(), user.getUsername(), user.getEmail(), user.getPassword()
        );
    }

    @Override
    public User retrieveById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM Users WHERE id = ?",
            new BeanPropertyRowMapper<>(User.class),
            id
        );
    }

    @Override
    public List<User> retreiveAll() {
        return jdbcTemplate.query(
            "SELECT * FROM Users",
            new BeanPropertyRowMapper<>(User.class)
        );
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.query(
            "DELETE FROM Users WHERE id = ?",
            new BeanPropertyRowMapper<>(User.class),
            id
        );
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.query(
            "DELETE FROM Users",
            new BeanPropertyRowMapper<>(User.class)
        );
    }


}
