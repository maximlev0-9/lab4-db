package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.GeneralDao;
import ua.lviv.iot.lab_4.model.User;

//working
public class UserDaoImpl extends AbstractGeneralDao<User> implements GeneralDao<User> {
    public UserDaoImpl() {
        super(User.class);
    }
}
