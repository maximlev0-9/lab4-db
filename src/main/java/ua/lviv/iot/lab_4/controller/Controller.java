package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;

import java.util.List;

public class Controller<T> {
    private final AbstractGeneralDao<T> dao;

    public Controller(AbstractGeneralDao<T> dao) {
        this.dao = dao;
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public T save(T t) {
        return dao.save(t);
    }

    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }

    public T findOne(int id) {
        return dao.findOne(id);
    }

    public boolean update(T t, int id) {
        return dao.update(t, id);
    }

    public int count() {
        return dao.count();
    }

}
