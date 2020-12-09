package ua.lviv.iot.lab_4.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Room extends RepresentationModel<Room> implements IWithId {
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
