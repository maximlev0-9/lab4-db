package ua.lviv.iot.lab_4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Zone extends RepresentationModel<Zone> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonBackReference("zones")
    @ManyToOne(cascade = CascadeType.ALL)
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

}
