package ua.lviv.iot.lab_4.business.impl;

import ua.lviv.iot.lab_4.business.AbstractGeneralDao;
import ua.lviv.iot.lab_4.business.UserDao;
import ua.lviv.iot.lab_4.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractGeneralDao<User> implements UserDao {


    public UserDaoImpl() {
        super("user");
    }

    // todo: implement these
    @Override
    protected List<User> createListFromResultSet(ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            User user = new User();
            try {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getByte("age"));
                user.setGender(resultSet.getString("gender"));
                // todo: do sth about it
//                user.setRoleId(resultSet.getInt("role_id"));
                users.add(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return users;
    }

    @Override
    protected String createSqlForSaving(User user) {
        return null;
    }

    @Override
    protected PreparedStatement createPreparedStatementForSaving(User user) {
        return null;
    }

    @Override
    protected User createObjectFromResultSet(ResultSet rs) {
        return null;
    }

    @Override
    protected String createSqlForUpdating(User user, int id) {
        return null;
    }
}
