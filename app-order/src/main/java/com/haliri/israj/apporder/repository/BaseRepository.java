package com.haliri.israj.apporder.repository;

import java.util.List;

public interface BaseRepository<T> {

    List<T> find(String search, Integer limit, Integer offset);

    T findById(Object parameter);

    void save(T t);

    void update(T t);

    void delete(Object parameter);
}
