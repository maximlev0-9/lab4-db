package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class Room {
    private int id;
    private int objectId;
    private int zoneId;
    private int typeId;
    private double lengthInMeters;
    private double widthInMeters;
    private double heightInMeters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return id == room.id &&
                objectId == room.objectId &&
                zoneId == room.zoneId &&
                typeId == room.typeId &&
                Double.compare(room.lengthInMeters, lengthInMeters) == 0 &&
                Double.compare(room.widthInMeters, widthInMeters) == 0 &&
                Double.compare(room.heightInMeters, heightInMeters) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objectId, zoneId, typeId, lengthInMeters, widthInMeters, heightInMeters);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
}
