package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class DeviceNotification {
    private int id;
    private int message;
    private boolean isSeen;
    private boolean deviceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceNotification)) return false;
        DeviceNotification that = (DeviceNotification) o;
        return id == that.id &&
                message == that.message &&
                isSeen == that.isSeen &&
                deviceId == that.deviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, isSeen, deviceId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    public boolean isDeviceId() {
        return deviceId;
    }

    public void setDeviceId(boolean deviceId) {
        this.deviceId = deviceId;
    }
}
