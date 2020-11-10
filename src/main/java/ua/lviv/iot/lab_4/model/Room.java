package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class Room {
    private int id;
    private MyObject object;
    private Zone zone;
    private RoomType roomType;
    private double lengthInMeters;
    private double widthInMeters;
    private double heightInMeters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return id == room.id &&
                object == room.object &&
                zone == room.zone &&
                roomType == room.roomType &&
                Double.compare(room.lengthInMeters, lengthInMeters) == 0 &&
                Double.compare(room.widthInMeters, widthInMeters) == 0 &&
                Double.compare(room.heightInMeters, heightInMeters) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, object, zone, roomType, lengthInMeters, widthInMeters, heightInMeters);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyObject getObject() {
        return object;
    }

    public void setObject(MyObject object) {
        this.object = object;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getLengthInMeters() {
        return lengthInMeters;
    }

    public void setLengthInMeters(double lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }

    public double getWidthInMeters() {
        return widthInMeters;
    }

    public void setWidthInMeters(double widthInMeters) {
        this.widthInMeters = widthInMeters;
    }

    public double getHeightInMeters() {
        return heightInMeters;
    }

    public void setHeightInMeters(double heightInMeters) {
        this.heightInMeters = heightInMeters;
    }

    @Override
    public String toString() {
        return "\nRoom{" +
                "id=" + id +
                ", objectId=" + object +
                ", zoneId=" + zone +
                ", typeId=" + roomType +
                ", \nlengthInMeters=" + lengthInMeters +
                ", widthInMeters=" + widthInMeters +
                ", heightInMeters=" + heightInMeters +
                '}';
    }
}
