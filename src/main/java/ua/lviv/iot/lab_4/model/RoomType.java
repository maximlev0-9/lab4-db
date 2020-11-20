package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class RoomType {
    private int id;
    private String type;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomType)) return false;
        RoomType roomType = (RoomType) o;
        return id == roomType.id &&
                Objects.equals(type, roomType.type);
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
        return "RoomType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
