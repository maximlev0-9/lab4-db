package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.RoleDao;
import ua.lviv.iot.lab_4.model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// working
public class RoleDaoImpl extends AbstractGeneralDao<Role> implements RoleDao {

    public RoleDaoImpl() {
        super("role");
    }

    // todo: check these

    @Override
    protected String createSqlForSaving() {
        return "insert into " + nameOfTable + "(role) values (?)";
    }

    @Override
    protected void preparePreparedStatementForSaving(PreparedStatement statement, Role role) {
        try {
            statement.setString(1, role.getRole());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected Role createObjectFromResultSet(ResultSet rs) {
        Role role = new Role();
        try {
            role.setId(rs.getInt(1));
            role.setRole(rs.getString("role"));
        } catch (SQLException throwables) {
//            throwables.printStackTrace();
        }
        return role;
    }

    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, Role role, int id) {
        try {
            stmt.setString(1, role.getRole());
            stmt.setInt(2, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected String createSqlForUpdating() {
        return "update " + nameOfTable + " set role=? where id=?";
    }
}
