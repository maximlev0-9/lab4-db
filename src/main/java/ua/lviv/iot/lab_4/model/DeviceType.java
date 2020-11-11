package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class DeviceType {
    private int id;
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceType)) return false;
        DeviceType that = (DeviceType) o;
        return id == that.id &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DeviceType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
