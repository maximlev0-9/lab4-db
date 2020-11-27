package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.impl.RoleDaoImpl;
import ua.lviv.iot.lab_4.model.Role;

public class RoleController extends GeneralController<Role> {
    public RoleController() {
        super(new RoleDaoImpl());
    }
}
