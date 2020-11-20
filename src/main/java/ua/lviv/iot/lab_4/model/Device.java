package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class Device {
    private int id;
    private Room room;
    private int model;
    private int placingId;
    private int batteryCharge;
    private DeviceType deviceType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return id == device.id &&
                room == device.room &&
                model == device.model &&
                placingId == device.placingId &&
                batteryCharge == device.batteryCharge &&
                deviceType == device.deviceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, room, model, placingId, batteryCharge, deviceType);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "\nDevice{" +
                "id=" + id +
                ", roomId=" + room.getId() +
                ", model=" + model +
                ", placingId=" + placingId +
                ", batteryCharge=" + batteryCharge +
                ", typeId=" + deviceType.getId() +
                '}';
    }
}
