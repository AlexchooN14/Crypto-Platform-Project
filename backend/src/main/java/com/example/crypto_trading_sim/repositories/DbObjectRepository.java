package com.example.crypto_trading_sim.repositories;

import java.util.List;

public interface DbObjectRepository<T> {
    public void insert(T t);

    public T retrieveById(Long id);

    public List<T> retreiveAll();

    public void deleteById(Long id);

    public void deleteAll();
}
