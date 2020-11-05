package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.model.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoomDaoImpl extends AbstractGeneralDao<Room> {
    public RoomDaoImpl() {
        super("room");
    }

    @Override
    protected String createSqlForSaving() {
        return null;
    }

    @Override
    protected void preparePreparedStatementForSaving(PreparedStatement statement, Room room) {

    }

    @Override
    protected Room createObjectFromResultSet(ResultSet rs) {
        return null;
    }

    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, Room room, int id) {

    }

    @Override
    protected String createSqlForUpdating() {
        return null;
    }
}
