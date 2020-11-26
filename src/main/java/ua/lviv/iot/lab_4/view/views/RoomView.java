package ua.lviv.iot.lab_4.view.views;

import ua.lviv.iot.lab_4.dao.impl.RoomDaoImpl;
import ua.lviv.iot.lab_4.model.MyObject;
import ua.lviv.iot.lab_4.model.Room;
import ua.lviv.iot.lab_4.model.RoomType;
import ua.lviv.iot.lab_4.model.Zone;

public class RoomView extends AbstractView<Room> {
    public RoomView() {
        super(new RoomDaoImpl());
    }

    @Override
    protected void addNewObject() {
        Room newRoom = new Room();
        System.out.println("Enter it's params:");
        System.out.print("Object id: ");
        MyObject object = new MyObject();
        object.setId(input.nextInt());
        newRoom.setObject(object);
        System.out.print("Zone id: ");
        Zone zone = new Zone();
        zone.setId(input.nextInt());
        newRoom.setZone(zone);
        System.out.print("Room type id: ");
        RoomType type = new RoomType();
        type.setId(input.nextInt());
        newRoom.setType(type);
        System.out.print("length (in meters): ");
        newRoom.setLengthInMeters(input.nextInt());
        System.out.print("width (in meters): ");
        newRoom.setWidthInMeters(input.nextInt());
        System.out.print("height (in meters): ");
        newRoom.setHeightInMeters(input.nextInt());
        controller.save(newRoom);
        System.out.println("Saved successfully");
    }

    @Override
    protected void updateObject() {
        // todo: do
        System.out.print("Enter id of room to be updated: ");
        int id = input.nextInt();
        Room newRoom = new Room();
        System.out.println("Enter it's params:");
        System.out.print("Object id: ");
        MyObject object = new MyObject();
        object.setId(input.nextInt());
        newRoom.setObject(object);
        System.out.print("Zone id: ");
        Zone zone = new Zone();
        zone.setId(input.nextInt());
        newRoom.setZone(zone);
        System.out.print("Room type id: ");
        RoomType type = new RoomType();
        type.setId(input.nextInt());
        newRoom.setType(type);
        System.out.print("length (in meters): ");
        newRoom.setLengthInMeters(input.nextInt());
        System.out.print("width (in meters): ");
        newRoom.setWidthInMeters(input.nextInt());
        System.out.print("height (in meters): ");
        newRoom.setHeightInMeters(input.nextInt());
        controller.update(newRoom, id);
        System.out.println("Updated successfully");
    }
}
