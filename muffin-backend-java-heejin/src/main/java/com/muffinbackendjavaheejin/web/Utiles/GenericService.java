package com.muffinbackendjavaheejin.web.Utiles;

import java.util.Optional;

public interface GenericService<T> {
    public Optional<T> findById(long id);
    public Iterable<T> findAll();
    public int count();
    public void delete(long id);
    public boolean exist(long id);
}
