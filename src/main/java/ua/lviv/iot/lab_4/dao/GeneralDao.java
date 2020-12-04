package ua.lviv.iot.lab_4.dao;

import org.hibernate.Session;
import ua.lviv.iot.lab_4.Connector;
import ua.lviv.iot.lab_4.model.IWithId;

import java.util.List;

public interface GeneralDao<T extends IWithId> {

    List<T> findAll();


    T save(T t);

    void deleteById(int id);

    T findOne(int id);

    void update(T t, int id);

    String getName();

    String getSqlForFindingAll();

    Class<T> getClassOfThis();

    default Session getSession() {
        return Connector.getSession();
    }
}
