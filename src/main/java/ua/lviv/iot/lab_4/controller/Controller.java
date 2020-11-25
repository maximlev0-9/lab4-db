package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;

import java.util.List;

public final class Controller<T> {
    private final AbstractGeneralDao<T> dao;

    public Controller(final AbstractGeneralDao<T> passedDao) {
        this.dao = passedDao;
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public T save(final T t) {
        return dao.save(t);
    }

    public boolean deleteById(final int id) {
        return dao.deleteById(id);
    }

    public T findOne(final int id) {
        return dao.findOne(id);
    }

    public boolean update(final T t, final int id) {
        return dao.update(t, id);
    }
}
