package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.impl.UserDaoImpl;
import ua.lviv.iot.lab_4.model.User;

public class UserController extends GeneralController<User> {
    public UserController() {
        super(new UserDaoImpl());
    }
}
