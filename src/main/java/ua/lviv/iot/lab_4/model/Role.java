package ua.lviv.iot.lab_4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Role extends RepresentationModel<Role> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private List<Zone> zones;
    @OneToMany(mappedBy = "role")
    @JsonBackReference
    private List<User> users;

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

    @Override
    public String toString() {
        return "\nRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
