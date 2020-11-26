package ua.lviv.iot.lab_4.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Zone implements IWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Role role;

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", role id=" + role.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zone)) return false;
        Zone zone = (Zone) o;
        return id == zone.id &&
                Objects.equals(role, zone.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
