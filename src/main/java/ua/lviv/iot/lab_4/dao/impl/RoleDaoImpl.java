package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.RoleDao;
import ua.lviv.iot.lab_4.model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl extends AbstractGeneralDao<Role> implements RoleDao {

    public RoleDaoImpl() {
        super("role");
    }

    // todo: implement these
    @Override
    protected List<Role> createListFromResultSet(ResultSet resultSet) {
        List<Role> roles = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Role role = new Role();
            try {
                role.setId(resultSet.getInt("id"));
                role.setRole(resultSet.getString("role"));
                roles.add(role);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return roles;
    }

    @Override
    protected String createSqlForSaving() {
        return "insert into ?(role) values (?)";
    }

    @Override
    protected void preparePreparedStatementForSaving(PreparedStatement statement, Role role) {

    }

//    @Override
    protected PreparedStatement createPreparedStatementForSaving(Role role) {
        String sql = createSqlForSaving();
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {

            stmt.setString(1, nameOfTable);
            stmt.setString(2, role.getRole());
            return stmt;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    protected Role createObjectFromResultSet(ResultSet rs) {
        return null;
    }

    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, Role role, int id) {

    }

    @Override
    protected String createSqlForUpdating() {
        return null;
    }
}
