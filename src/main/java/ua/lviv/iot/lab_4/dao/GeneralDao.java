package ua.lviv.iot.lab_4.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.lab_4.Connector;
import ua.lviv.iot.lab_4.model.IWithId;

import java.util.List;

public interface GeneralDao<T extends IWithId> {

    List<T> findAll();

    default List<T> findAllDefault() {
        Session session = getSession();
        session.beginTransaction();
        String sqlForFindingAll = getSqlForFindingAll();
        Query<T> query = session.createQuery(sqlForFindingAll, getClassOfThis());
        List<T> resultList = query.getResultList();
        session.getTransaction().commit();
        return resultList;
    }

    T save(T t);

    default T saveDefault(T t) {
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

    void deleteById(int id);

    default void deleteByIdDefault(int id) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(findOneDefault(id));
        session.getTransaction().commit();

    }

    T findOne(int id);

    default T findOneDefault(int id) {
        Session session = getSession();
        T t = session.find(getClassOfThis(), id);
        return t;
    }

    void update(T t, int id);

    default void updateDefault(T t, int id) {
        Session session = getSession();
        session.beginTransaction();
        t.setId(id);
        session.merge(t);
        session.getTransaction().commit();
    }

    String getName();

    String getSqlForFindingAll();

    Class<T> getClassOfThis();

    default Session getSession() {
        return Connector.getSession();
    }
}
