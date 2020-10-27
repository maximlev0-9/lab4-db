package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class SystemNotification {
    private int id;
    private String message;
    private boolean isSeen;
    private int objectId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SystemNotification)) return false;
        SystemNotification that = (SystemNotification) o;
        return id == that.id &&
                isSeen == that.isSeen &&
                objectId == that.objectId &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, isSeen, objectId);
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

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }
}
