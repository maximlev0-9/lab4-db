package ua.lviv.iot.lab_4.dao;

import java.util.List;

public interface GeneralDao<T> {

    List<T> findAll();

    T save(T t);

    boolean deleteById(int id);

    T findOne(int id);

    boolean update(T t, int id);

    int count();
}
