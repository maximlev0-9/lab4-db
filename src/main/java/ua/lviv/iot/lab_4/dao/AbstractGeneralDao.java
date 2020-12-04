package ua.lviv.iot.lab_4.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;
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
        Session session = getSession();
        session.beginTransaction();
        String sqlForFindingAll = getSqlForFindingAll();
        Query<T> query = session.createQuery(sqlForFindingAll, getClassOfThis());
        List<T> resultList = query.getResultList();
        session.getTransaction().commit();
        return resultList;
    }


    @Override
    public T save(T t) {
        Session session = getSession();
        try {
            session.beginTransaction();
            Integer id = (Integer) session.save(t);
            t.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            getSession().getTransaction().commit();
        }
        return t;
    }

    @Override
    public void deleteById(int id) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(findOne(id));
        session.getTransaction().commit();
    }

    @Override
    public T findOne(int id) {
        Session session = getSession();
        return session.find(getClassOfThis(), id);
    }

    @Override
    public void update(T t, int id) {
        Session session = getSession();
        session.beginTransaction();
        t.setId(id);
        session.merge(t);
        session.getTransaction().commit();
    }

    @Override
    public String getSqlForFindingAll() {
        return "SELECT a FROM " + getName() + " a";
    }
}
