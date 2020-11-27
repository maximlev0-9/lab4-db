package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.impl.RoomDaoImpl;
import ua.lviv.iot.lab_4.model.Room;

public class RoomController extends GeneralController<Room> {
    public RoomController() {
        super(new RoomDaoImpl());
    }
}
