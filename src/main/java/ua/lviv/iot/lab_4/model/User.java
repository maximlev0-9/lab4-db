package ua.lviv.iot.lab_4.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User implements IWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Role role;
    private String name;
    private byte age;
    private String gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                role == user.role &&
                age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(gender, user.gender);
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", role id=" + role.getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, name, age, gender);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role roleId) {
        this.role = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
