package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.model.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDaoImpl extends AbstractGeneralDao<Address> {

    public AddressDaoImpl() {
        super("address");
    }

    @Override
    protected String createSqlForSaving() {
        return "insert into " + nameOfTable + "(country, city, street, buildingNumber, flatNumber) values(?,?,?,?,?)";
    }

    @Override
    protected void preparePreparedStatementForSaving(PreparedStatement statement, Address address) {
        try {
            statement.setInt(1, address.getBuildingNumber());
            statement.setInt(2, address.getFlatNumber());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getCountry());
            statement.setString(5, address.getStreet());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected Address createObjectFromResultSet(ResultSet rs) {
        Address address = new Address();
        try {
            address.setId(rs.getInt(1));
            address.setBuildingNumber(rs.getInt("building_number"));
            address.setCity(rs.getString("city"));
            address.setCountry(rs.getString("country"));
            address.setFlatNumber(rs.getInt("flat_number"));
            address.setStreet(rs.getString("street"));

        } catch (SQLException ignored) {
        }
        return address;
    }

    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, Address address, int id) {
        preparePreparedStatementForSaving(stmt, address);
        try {
            stmt.setInt(6, id);
        } catch (SQLException ignored) {
        }
    }

    @Override
    protected String createSqlForUpdating() {
        return "update " + nameOfTable + " set country=?, city=?, street=?, buildingNumber=?, flatNumber=? where id=?";

    }
}
