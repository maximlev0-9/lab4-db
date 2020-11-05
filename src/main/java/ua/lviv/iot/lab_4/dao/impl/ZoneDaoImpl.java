package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.ZoneDao;
import ua.lviv.iot.lab_4.model.Zone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZoneDaoImpl extends AbstractGeneralDao<Zone> implements ZoneDao {

    public ZoneDaoImpl() {
        super("zone");
    }


    @Override
    protected String createSqlForSaving() {
        return "insert into " + nameOfTable + "(role_id) values (?)";
    }

    @Override
    protected void preparePreparedStatementForSaving(PreparedStatement statement, Zone zone) {
        try {
            statement.setInt(1, zone.getRoleId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected Zone createObjectFromResultSet(ResultSet rs) {
        Zone newZone = new Zone();
        try {
            newZone.setId(rs.getInt(1));
            newZone.setRoleId(rs.getInt("role_id"));
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
        }
        return newZone;
    }

    @Override
    protected String createSqlForUpdating() {
        return "update " + nameOfTable + " set role_id=? where id=?";
    }

    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, Zone zone, int id) {
        try {
            stmt.setInt(1, zone.getRoleId());
            stmt.setInt(2, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
