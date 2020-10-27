package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class Zone {
    private int id;
    private int roleId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zone)) return false;
        Zone zone = (Zone) o;
        return id == zone.id &&
                roleId == zone.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
