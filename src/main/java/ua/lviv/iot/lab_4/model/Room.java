package ua.lviv.iot.lab_4.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Room implements IWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private MyObject object;
    @ManyToOne
    private Zone zone;
    @OneToOne
    private RoomType type;
    @Column(name = "lenght")
    private double lengthInMeters;
    @Column(name = "width")
    private double widthInMeters;
    @Column(name = "height")
    private double heightInMeters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return id == room.id &&
                object == room.object &&
                zone == room.zone &&
                type == room.type &&
                Double.compare(room.lengthInMeters, lengthInMeters) == 0 &&
                Double.compare(room.widthInMeters, widthInMeters) == 0 &&
                Double.compare(room.heightInMeters, heightInMeters) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, object, zone, type, lengthInMeters, widthInMeters, heightInMeters);
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

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType roomType) {
        this.type = roomType;
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
                ", objectId=" + object.getId() +
                ", zoneId=" + zone.getId() +
                ", typeId=" + type.getId() +
                ", \nlengthInMeters=" + lengthInMeters +
                ", widthInMeters=" + widthInMeters +
                ", heightInMeters=" + heightInMeters +
                '}';
    }
}
