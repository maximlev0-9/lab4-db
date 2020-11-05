package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.dao.impl.RoomDaoImpl;
import ua.lviv.iot.lab_4.model.Room;

public class RoomView extends AbstractView<Room> {
    public RoomView() {
        super(new RoomDaoImpl());
    }

    @Override
    protected void addNewObject() {

    }

    @Override
    protected void deleteObject() {

    }

    @Override
    protected void updateObject() {

    }
}
