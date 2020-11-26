package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.model.IWithId;

import java.util.List;

public final class Controller<T extends IWithId> {
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

    public void deleteById(final int id) {
        dao.deleteById(id);
    }

    public T findOne(final int id) {
        return dao.findOne(id);
    }

    public void update(final T t, final int id) {
        dao.update(t, id);
    }
}
