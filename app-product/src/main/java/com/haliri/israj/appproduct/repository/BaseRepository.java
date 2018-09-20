package com.haliri.israj.appproduct.repository;

import java.util.List;

public interface BaseRepository<T> {

    List<T> find(String search, Integer limit, Integer offset);

    T findById(Object parameter);

    T save(T t);

    T update(T t);

    void delete(Object parameter);
}
