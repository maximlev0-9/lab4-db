package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.ZoneDao;
import ua.lviv.iot.lab_4.model.Zone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ZoneDaoImpl extends AbstractGeneralDao<Zone> implements ZoneDao {
    public ZoneDaoImpl() {
        super("zone");
    }

    @Override
    protected List<Zone> createListFromResultSet(ResultSet resultSet) {
        return null;
    }

    @Override
    protected String createSqlForSaving() {
        return null;
    }

    @Override
    protected void preparePreparedStatementForSaving(PreparedStatement statement, Zone zone) {

    }

    @Override
    protected Zone createObjectFromResultSet(ResultSet rs) {
        return null;
    }

    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, Zone zone, int id) {

    }

    @Override
    protected String createSqlForUpdating() {
        return null;
    }
}
