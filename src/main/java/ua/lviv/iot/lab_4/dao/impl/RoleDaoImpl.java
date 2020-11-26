package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.GeneralDao;
import ua.lviv.iot.lab_4.model.Role;

// working
public class RoleDaoImpl extends AbstractGeneralDao<Role> implements GeneralDao<Role> {

    public RoleDaoImpl() {
        super(Role.class);
    }
}
