package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.model.Room;
import ua.lviv.iot.lab_4.model.RoomType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomDaoImpl extends AbstractGeneralDao<Room> {
    public RoomDaoImpl() {
        super("room");
    }

    @Override
    protected String createSqlForSaving() {
        return "insert into " + nameOfTable + "(object_id, zone_id, type_id, length, width, height) values (?,?,?,?,?,?)";
    }

    @Override
    protected void preparePreparedStatementForSaving(PreparedStatement statement, Room room) {
        try {
            statement.setInt(1, room.getObject().getId());
            statement.setInt(2, room.getZone().getId());
            statement.setInt(3, room.getRoomType().getId());
            statement.setDouble(4, room.getLengthInMeters());
            statement.setDouble(5, room.getWidthInMeters());
            statement.setDouble(6, room.getHeightInMeters());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected Room createObjectFromResultSet(ResultSet rs) {
        Room room = new Room();
        try {
            room.setId(rs.getInt(1));
            room.setHeightInMeters(rs.getDouble("height"));
            room.setLengthInMeters(rs.getDouble("length"));
            room.setWidthInMeters(rs.getDouble("width"));
            room.setObject(new ObjectDaoImpl().findOne(rs.getInt("object_id")));
            room.setZone(new ZoneDaoImpl().findOne(rs.getInt("zone_id")));

            Statement statement = getConnection().createStatement();
            ResultSet set = statement.executeQuery("select * from room_type where id=" + rs.getInt("type_id"));
            RoomType roomType = new RoomType();
            roomType.setId(set.getInt(1));
            roomType.setType(set.getString("type"));
            set.close();
            statement.close();
            room.setRoomType(roomType);
        } catch (SQLException ignored) {
        }
        return room;

    }

    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, Room room, int id) {
        try {
            preparePreparedStatementForSaving(stmt, room);
            stmt.setInt(7, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected String createSqlForUpdating() {
        return "update " + nameOfTable + " set object_id=?, zone_id=?, type_id=?, length=?, width=?, height=?) where id=?";
    }
}
