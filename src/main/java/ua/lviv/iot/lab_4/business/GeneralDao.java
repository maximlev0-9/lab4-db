package ua.lviv.iot.lab_4.business;

import java.util.List;

public interface GeneralDao<T> {

    List<T> findAll();

    T save(T t);

    boolean deleteById(int id);

    boolean exists(T t);

    boolean existsById(int id);

    T findOne(int id);

    T update(T t, int id);

    int count();
}
