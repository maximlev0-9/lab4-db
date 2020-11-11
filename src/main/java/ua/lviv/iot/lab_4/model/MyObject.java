package ua.lviv.iot.lab_4.model;

import java.util.Objects;

public class MyObject {
    private int id;
    private String name;
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyObject)) return false;
        MyObject myObject = (MyObject) o;
        return id == myObject.id &&
                address == myObject.address &&
                Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nMyObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressId=" + address +
                '}';
    }
}
