package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class DeviceSettings {
    private int id;
    private int brightness;
    private int volume;
    private int deviceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceSettings)) return false;
        DeviceSettings that = (DeviceSettings) o;
        return id == that.id &&
                brightness == that.brightness &&
                volume == that.volume &&
                deviceId == that.deviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brightness, volume, deviceId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }
}
