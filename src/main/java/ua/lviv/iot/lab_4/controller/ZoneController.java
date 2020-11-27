package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.impl.ZoneDaoImpl;
import ua.lviv.iot.lab_4.model.Zone;

public class ZoneController extends GeneralController<Zone> {
    public ZoneController() {
        super(new ZoneDaoImpl());
    }
}
