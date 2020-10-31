package ua.lviv.iot.lab_4.business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeneralDao<T> implements GeneralDao<T> {
    private final String name;
    protected Connection conn = null;

    public AbstractGeneralDao(String name) {
        this.name = name;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ajax_systems_v3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                    , "ioter", "New_password1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<T> findAll() {
        try (Statement stmt = conn.createStatement()) {
            String sql = new StringBuilder().append("SELECT * from ").append(name).append(";").toString();
            try (ResultSet resultSet = stmt.executeQuery(sql)) {
                return createListFromResultSet(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }

    protected abstract List<T> createListFromResultSet(ResultSet resultSet);


//    List<Employee> employees = new ArrayList<>();
//    while (resultSet.next()) {
//        Employee emp = new Employee();
//        emp.setId(resultSet.getInt("emp_id"));
//        emp.setName(resultSet.getString("name"));
//        emp.setPosition(resultSet.getString("position"));
//        emp.setSalary(resultSet.getDouble("salary"));
//        employees.add(emp);
//    }

    public T save(T t) {
        try (PreparedStatement stmt = createPreparedStatementForSaving(t)) {
            String sql = createSqlForSaving(t);
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                return createObjectFromResultSet(rs);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    protected abstract String createSqlForSaving(T t);

    protected abstract PreparedStatement createPreparedStatementForSaving(T t);

    public boolean deleteById(int id) {
        try (Statement stmt = conn.createStatement()) {
            String sql = new StringBuilder().append("Delete from ").append(name).append(" where id=").append(id).append(";").toString();
            stmt.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public T findOne(int id) {
        String sql = new StringBuilder().append("select * from ").append(name).append(" where id=").append(id).append(";").toString();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            T t = createObjectFromResultSet(rs);
            rs.close();
            return t;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    protected abstract T createObjectFromResultSet(ResultSet rs);


    // todo: implement this
    public boolean update(T t, int id) {
        String sql = createSqlForUpdating(t, id);
        return false;
    }

    protected abstract String createSqlForUpdating(T t, int id);

    public int count() {
        String sql = "SELECT COUNT(*) from " + name + ";";
        try (Statement stmt = conn.createStatement()) {
            try(ResultSet rs = stmt.executeQuery(sql)){
                return rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
