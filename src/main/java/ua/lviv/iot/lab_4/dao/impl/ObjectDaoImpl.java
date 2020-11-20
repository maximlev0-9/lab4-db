package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.model.Address;
import ua.lviv.iot.lab_4.model.MyObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectDaoImpl extends AbstractGeneralDao<MyObject> {

    public ObjectDaoImpl() {
        super("object");
    }

    @Override
    protected String createSqlForSaving() {
        return "insert into " + nameOfTable + "(name, address_id) values (?,?)";
    }

    @Override
    protected void preparePreparedStatementForSaving(PreparedStatement statement, MyObject myObject) {
        try {
            statement.setString(1, myObject.getName());
            statement.setInt(2, myObject.getAddress().getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected MyObject createObjectFromResultSet(ResultSet rs) {

        MyObject object = new MyObject();
        try {
            object.setId(rs.getInt(1));
            object.setName(rs.getString("name"));
            int addressId = rs.getInt("address_id");
            Address address = new Address();
            address.setId(addressId);
            object.setAddress(address);
        } catch (SQLException ignored) {
        }
        return object;
    }

    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, MyObject myObject, int id) {
        preparePreparedStatementForSaving(stmt, myObject);
        try {
            stmt.setInt(3, id);
        } catch (SQLException ignored) {
        }
    }

    @Override
    protected String createSqlForUpdating() {
        return "update " + nameOfTable + " set name=?, address_id=? where id=?";
    }
}
