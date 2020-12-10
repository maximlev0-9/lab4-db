package ua.lviv.iot.lab_4.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "system_notification")
public class SystemNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    private boolean isSeen;
    @OneToOne
    private MyObject myObject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemNotification)) return false;
        SystemNotification that = (SystemNotification) o;
        return id == that.id &&
                isSeen == that.isSeen &&
                Objects.equals(message, that.message) &&
                Objects.equals(myObject, that.myObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, isSeen, myObject);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    public MyObject getMyObject() {
        return myObject;
    }

    public void setMyObject(MyObject myObject) {
        this.myObject = myObject;
    }
}
