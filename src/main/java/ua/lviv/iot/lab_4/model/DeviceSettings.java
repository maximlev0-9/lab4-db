package ua.lviv.iot.lab_4.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "device_settings")
public class DeviceSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int brightness;
    private int volume;
    @OneToOne
    private Device device;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceSettings)) return false;
        DeviceSettings that = (DeviceSettings) o;
        return id == that.id &&
                brightness == that.brightness &&
                volume == that.volume &&
                Objects.equals(device, that.device);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brightness, volume, device);
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

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
