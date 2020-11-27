package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.model.MyObject;

// working
public class ObjectDaoImpl extends AbstractGeneralDao<MyObject> {

    public ObjectDaoImpl() {
        super(MyObject.class);
    }
}
