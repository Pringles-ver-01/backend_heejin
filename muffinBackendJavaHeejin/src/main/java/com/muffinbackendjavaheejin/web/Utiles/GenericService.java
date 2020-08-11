package com.muffinbackendjavaheejin.web.Utiles;

import java.util.Optional;

public interface GenericService<T> {
    public Optional<T> findById(String id);
    public Iterable<T> findAll();
    public int count();
    public void delete(String id);
    public boolean exist(String id);
}
