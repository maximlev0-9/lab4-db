package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.GeneralDao;
import ua.lviv.iot.lab_4.model.Zone;

// working
public class ZoneDaoImpl extends AbstractGeneralDao<Zone> implements GeneralDao<Zone> {
    public ZoneDaoImpl() {
        super(Zone.class);
    }
}
