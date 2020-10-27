package ua.lviv.iot.lab_4.business.impl;

import ua.lviv.iot.lab_4.business.UserDao;
import ua.lviv.iot.lab_4.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean exists(User user) {
        return false;
    }

    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public User findOne(int id) {
        return null;
    }

    @Override
    public User update(User user, int id) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
