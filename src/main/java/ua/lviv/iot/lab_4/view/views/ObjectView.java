package ua.lviv.iot.lab_4.view.views;

import ua.lviv.iot.lab_4.dao.impl.ObjectDaoImpl;
import ua.lviv.iot.lab_4.model.Address;
import ua.lviv.iot.lab_4.model.MyObject;

public class ObjectView extends AbstractView<MyObject> {
    public ObjectView() {
        super(new ObjectDaoImpl());
    }

    @Override
    protected void addNewObject() {
        MyObject newObject = new MyObject();
        System.out.println("Enter it's params:");
        System.out.print("name: ");
        newObject.setName(input.nextLine());
        System.out.print("address id: ");
        Address a = new Address();
        a.setId(input.nextInt());
        newObject.setAddress(a);
        controller.save(newObject);
        System.out.println("Saved successfully");
    }

    @Override
    protected void updateObject() {
        System.out.print("Enter id of object to be updated: ");
        int id = input.nextInt();
        MyObject newObject = new MyObject();
        System.out.println("Enter it's params:");
        System.out.print("name: ");
        newObject.setName(input.nextLine());
        System.out.print("address id: ");
        Address a = new Address();
        a.setId(input.nextInt());
        newObject.setAddress(a);
        controller.update(newObject, id);
        System.out.println("Updated successfully");
    }
}
