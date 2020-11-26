package ua.lviv.iot.lab_4.dao;


import ua.lviv.iot.lab_4.model.IWithId;

import java.util.List;

public abstract class AbstractGeneralDao<T extends IWithId> implements GeneralDao<T> {
    private final Class<T> clazz;

    public AbstractGeneralDao(Class<T> tClass) {
        this.clazz = tClass;
    }

    @Override
    public String getName() {
        return clazz.getName();
    }

    @Override
    public Class<T> getClassOfThis() {
        return clazz;
    }

    @Override
    public List<T> findAll() {
        return findAllDefault();
    }


    @Override
    public T save(T t) {
        return saveDefault(t);
    }

    @Override
    public void deleteById(int id) {
        deleteByIdDefault(id);
    }

    @Override
    public T findOne(int id) {
        return findOneDefault(id);
    }

    @Override
    public void update(T t, int id) {
        updateDefault(t, id);
    }

    @Override
    public String getSqlForFindingAll() {
        return "SELECT a FROM " + getName() + " a";
    }
}
