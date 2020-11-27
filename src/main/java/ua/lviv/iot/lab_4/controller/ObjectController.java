package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.impl.ObjectDaoImpl;
import ua.lviv.iot.lab_4.model.MyObject;

public class ObjectController extends GeneralController<MyObject> {

    public ObjectController() {
        super(new ObjectDaoImpl());
    }
}
