package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class UserSecurity {
    private int id;
    private int userId;
    private String password;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSecurity)) return false;
        UserSecurity that = (UserSecurity) o;
        return id == that.id &&
                userId == that.userId &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, password);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
