package ua.lviv.iot.lab_4.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Device extends RepresentationModel<Device>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Room room;
    private int model;
    @ManyToOne(targetEntity = DevicePlacing.class)
    private DevicePlacing placing;
    @Column(name = "battery_charge")
    private int batteryCharge;
    @ManyToOne
    private DeviceType type;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return id == device.id &&
                model == device.model &&
                batteryCharge == device.batteryCharge &&
                Objects.equals(room, device.room) &&
                Objects.equals(placing, device.placing) &&
                Objects.equals(type, device.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, room, model, placing, batteryCharge, type);
    }

    public DevicePlacing getPlacing() {
        return placing;
    }

    public void setPlacing(DevicePlacing placing) {
        this.placing = placing;
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


    public int getBatteryCharge() {
        return batteryCharge;
    }

    public void setBatteryCharge(int batteryCharge) {
        this.batteryCharge = batteryCharge;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType deviceType) {
        this.type = deviceType;
    }

    @Override
    public String toString() {
        return "\nDevice{" +
                "id=" + id +
                ", roomId=" + room.getId() +
                ", model=" + model +
                ", placingId=" + placing.getId() +
                ", batteryCharge=" + batteryCharge +
                ", typeId=" + type.getId() +
                '}';
    }
}
