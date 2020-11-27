package ua.lviv.iot.lab_4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "device_placing")
public class DevicePlacing implements IWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String placing;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DevicePlacing)) return false;
        DevicePlacing that = (DevicePlacing) o;
        return id == that.id &&
                Objects.equals(placing, that.placing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placing);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlacing() {
        return placing;
    }

    public void setPlacing(String placing) {
        this.placing = placing;
    }
}
