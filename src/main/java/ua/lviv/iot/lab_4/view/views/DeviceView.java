package ua.lviv.iot.lab_4.view.views;

import ua.lviv.iot.lab_4.dao.impl.DeviceDaoImpl;
import ua.lviv.iot.lab_4.dao.impl.RoomDaoImpl;
import ua.lviv.iot.lab_4.model.Device;
import ua.lviv.iot.lab_4.model.DeviceType;
import ua.lviv.iot.lab_4.model.Room;

public class DeviceView extends AbstractView<Device> {
    public DeviceView() {
        super(new DeviceDaoImpl());
    }

    @Override
    protected void addNewObject() {
        Device newDevice = new Device();
        System.out.println("Enter it's params:");
        System.out.print("Room id: ");
        newDevice.setRoom(new RoomDaoImpl().findOne(input.nextInt()));
        System.out.print("Model (number): ");
        newDevice.setModel(input.nextInt());
        System.out.print("Placing id: ");
        newDevice.setPlacingId(input.nextInt());
        System.out.print("Battery charge: ");
        newDevice.setBatteryCharge(input.nextInt());
        System.out.print("Device type id: ");
        DeviceType typeId = new DeviceType();
        typeId.setId(input.nextInt());
        newDevice.setDeviceType(typeId);
        controller.save(newDevice);
        System.out.println("Saved successfully");
    }

    @Override
    protected void updateObject() {
        System.out.println("Enter id of device to be updated: ");
        int id = input.nextInt();
        Device newDevice = new Device();
        System.out.println("Enter new params:");
        System.out.print("Room id: ");
        input.nextLine();
        int roomId = input.nextInt();
        Room room = new Room();
        room.setId(roomId);
        newDevice.setRoom(room);
        System.out.print("Model: ");
        int model = input.nextInt();
        newDevice.setModel(model);
        System.out.print("Placing id: ");
        int placing = input.nextInt();
        newDevice.setPlacingId(placing);
        System.out.print("Battery charge: ");
        int charge = input.nextInt();
        newDevice.setBatteryCharge(charge);
        System.out.print("Device type id: ");
        int typeId = input.nextInt();
        DeviceType type = new DeviceType();
        type.setId(typeId);
        newDevice.setDeviceType(type);
        controller.update(newDevice, id);
        System.out.println("Updated successfully");
    }
}
