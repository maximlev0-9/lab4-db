package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class MyObject {
    private int id;
    private String name;
    private int addressId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyObject)) return false;
        MyObject myObject = (MyObject) o;
        return id == myObject.id &&
                addressId == myObject.addressId &&
                Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addressId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
