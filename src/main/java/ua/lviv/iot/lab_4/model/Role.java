package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class Role {
    private int id;
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role o1 = (Role) o;
        return id == o1.id &&
                Objects.equals(this.role, o1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "\nRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
