package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class Device {
    private int id;
    private int roomId;
    private int model;
    private int placingId;
    private int batteryCharge;
    private int typeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return id == device.id &&
                roomId == device.roomId &&
                model == device.model &&
                placingId == device.placingId &&
                batteryCharge == device.batteryCharge &&
                typeId == device.typeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, model, placingId, batteryCharge, typeId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getPlacingId() {
        return placingId;
    }

    public void setPlacingId(int placingId) {
        this.placingId = placingId;
    }

    public int getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
