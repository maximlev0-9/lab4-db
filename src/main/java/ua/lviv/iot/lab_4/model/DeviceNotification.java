package ua.lviv.iot.lab_4.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DeviceNotification implements IWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int message;
    private boolean isSeen;
    @OneToOne
    private Device device;


    @Override
    public String toString() {
        return "DeviceNotification{" +
                "id=" + id +
                ", message=" + message +
                ", isSeen=" + isSeen +
                ", device id=" + device.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeviceNotification)) return false;
        DeviceNotification that = (DeviceNotification) o;
        return id == that.id &&
                message == that.message &&
                isSeen == that.isSeen &&
                Objects.equals(device, that.device);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, isSeen, device);
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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

}
