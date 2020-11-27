package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.impl.DeviceDaoImpl;
import ua.lviv.iot.lab_4.model.Device;

public class DeviceController extends GeneralController<Device> {
    public DeviceController() {
        super(new DeviceDaoImpl());
    }
}
