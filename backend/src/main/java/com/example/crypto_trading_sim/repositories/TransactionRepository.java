package com.example.crypto_trading_sim.repositories;

import com.example.crypto_trading_sim.entities.Transaction;
import com.example.crypto_trading_sim.entities.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepository implements DbObjectRepository<Transaction> {
    private final JdbcTemplate jdbcTemplate;

    public TransactionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Transaction transaction) {
        jdbcTemplate.update(
            "INSERT INTO Transactions (id, user_id, ticker, action, quantity, price_per_unit) VALUES (?, ?, ?, ?, ?, ?)",
            transaction.getId(), transaction.getUserId(), transaction.getTicker(), transaction.getAction(),
            transaction.getQuantity(), transaction.getPricePerUnit()
        );
    }

    @Override
    public Transaction retrieveById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM Transactions WHERE id = ?",
            new BeanPropertyRowMapper<>(Transaction.class),
            id
        );
    }

    @Override
    public List<Transaction> retreiveAll() {
        return jdbcTemplate.query(
            "SELECT * FROM Transactions",
            new BeanPropertyRowMapper<>(Transaction.class)
        );
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.query(
            "DELETE FROM Transactions WHERE id = ?",
            new BeanPropertyRowMapper<>(Transaction.class),
            id
        );
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.query(
            "DELETE FROM Transactions",
            new BeanPropertyRowMapper<>(Transaction.class)
        );
    }
}
