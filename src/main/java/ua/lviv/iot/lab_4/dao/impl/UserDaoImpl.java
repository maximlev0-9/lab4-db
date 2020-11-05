package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.UserDao;
import ua.lviv.iot.lab_4.model.Role;
import ua.lviv.iot.lab_4.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractGeneralDao<User> implements UserDao {

    public UserDaoImpl() {
        super("user");
    }

    // todo: check these
    @Override
    protected List<User> createListFromResultSet(ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            User user = createObjectFromResultSet(resultSet);
            users.add(user);
        }
        return users;
    }

    @Override
    protected String createSqlForSaving() {
        return "insert into user(role_id, name, age, gender) values (?, ?, ?, ?)";
    }

    protected void preparePreparedStatementForSaving(PreparedStatement statement, User user) {
        try {
            statement.setInt(1, user.getRoleId().getId());
            statement.setString(2, user.getName());
            statement.setByte(3, user.getAge());
            statement.setString(4, user.getGender());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected User createObjectFromResultSet(ResultSet rs) {
        User newUser = new User();
        try {
            newUser.setId(rs.getInt(1));
            newUser.setName(rs.getString("name"));
            newUser.setGender(rs.getString("gender"));
            newUser.setAge(rs.getByte("age"));
            Role role = new Role();
            role.setId(rs.getByte("role_id"));
            newUser.setRoleId(role);
        } catch (SQLException throwables) {
            //todo: fix that
//            throwables.printStackTrace();
        }
        return newUser;
    }

    @Override
    protected String createSqlForUpdating() {
        return "update " + nameOfTable + " set role_id=?, name=?, gender=?, age=? where id=?";
    }

    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, User user, int id) {
        try {
            stmt.setInt(1, user.getRoleId().getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getGender());
            stmt.setByte(4, user.getAge());
            stmt.setInt(5, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public boolean deleteById(int id) {
        String sql2 = "Delete from user_security where id=?;";
        String sql = "Delete from " + nameOfTable + " where id=?;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             PreparedStatement stmt2 = conn.prepareStatement(sql2)) {
            stmt2.setInt(1, id);
            stmt.setInt(1, id);
            stmt2.executeUpdate();
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

}
