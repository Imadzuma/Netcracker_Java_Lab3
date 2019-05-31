package com.dao.api;

import java.util.List;

public interface Dao<T> {
    void delete(Integer id);
    void update(T model);
    void add(T model);
    T find(Integer id);

    Long count();
    List<T> findAll();
}
