package ua.lviv.iot.lab_4.dao;

import ua.lviv.iot.lab_4.model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeneralDao<T> implements GeneralDao<T> {
    private static final String DB_URL = "jdbc:mysql://localhost/ajax_systems_v3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String PASS = "New_password1";
    private static final String USER = "ioter";
    protected final String nameOfTable;


    public AbstractGeneralDao(String nameOfTable) {
        this.nameOfTable = nameOfTable;
    }

    protected Connection getConnection() {
        try {

            return DriverManager.getConnection(DB_URL,
                    USER, PASS);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<T> findAll() {
        String sql = "SELECT * FROM " + nameOfTable + ";";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = stmt.executeQuery()) {
                return createListFromResultSet(resultSet);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    protected List<T> createListFromResultSet(ResultSet resultSet) {
        List<T> tList = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            T t = createObjectFromResultSet(resultSet);

            tList.add(t);
        }
        return tList;
    }

    public T save(T t) {
        String sqlForSaving = createSqlForSaving();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sqlForSaving, Statement.RETURN_GENERATED_KEYS)) {
            preparePreparedStatementForSaving(stmt, t);
            stmt.executeUpdate();
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                return createObjectFromResultSet(rs);
            }
        } catch (SQLException throwables) {
            if (!throwables.getMessage().startsWith("java.sql.SQLIntegrityConstraintViolationException: Cannot add or update a child row: a foreign key constraint fails")){
                System.out.println("Error: there is no such id in params' tables");
            }
        }
        return null;
    }

    protected abstract String createSqlForSaving();

    protected abstract void preparePreparedStatementForSaving(PreparedStatement statement, T t);

    public boolean deleteById(int id) {
        String sql = "Delete from " + nameOfTable + " where id=?;";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException throwables) {
            if (!throwables.getMessage().startsWith("java.sql.SQLIntegrityConstraintViolationException: Cannot delete or update a parent row: a foreign key constraint fails")){
                System.out.println("Error: delete related foreign keys first");
            }
        }
        return true;
    }

    public T findOne(int id) {
        String sql = "select * from " + nameOfTable + " where id=?;";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return createObjectFromResultSet(rs);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    protected abstract T createObjectFromResultSet(ResultSet rs);


    // todo: implement this
    public boolean update(T t, int id) {
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement(createSqlForUpdating())) {
            preparePreparedStatementForUpdating(stmt, t, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    protected abstract void preparePreparedStatementForUpdating(PreparedStatement stmt, T t, int id);

    protected abstract String createSqlForUpdating();

    public int count() {
        String sql = "SELECT COUNT(*) from " + nameOfTable + ";";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public String getNameOfTable() {
        return nameOfTable;
    }
}
