package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.model.Device;

// working
public class DeviceDaoImpl extends AbstractGeneralDao<Device> {

    public DeviceDaoImpl() {
        super(Device.class);
    }
}
