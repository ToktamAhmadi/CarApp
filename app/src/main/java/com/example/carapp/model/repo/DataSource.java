package com.example.carapp.model.repo;

import java.util.List;

import io.reactivex.Single;

public interface DataSource<T,E> {
    Single<T> get(E id);
    Comparable delete(T item);
    Single<List<T>> getAll(int page);
    Single<T> inert(T item);
    Single<T> update(T item);
    
}
