package ua.lviv.iot.lab_4.view.views;

import ua.lviv.iot.lab_4.controller.ZoneController;
import ua.lviv.iot.lab_4.model.Role;
import ua.lviv.iot.lab_4.model.Zone;

public class ZoneView extends AbstractView<Zone> {
    public ZoneView() {
        super(new ZoneController());
    }

    @Override
    protected void addNewObject() {
        Zone newZone = new Zone();
        System.out.println("Enter it's params:");
        System.out.print("Role: ");
        Role role = new Role();
        role.setId(input.nextInt());
        newZone.setRole(role);
        controller.save(newZone);
        System.out.println("Saved successfully");
    }

    @Override
    protected void updateObject() {
        System.out.print("Enter id of zone to be updated: ");
        int id = input.nextInt();
        System.out.println("Enter it's params: ");
        input.nextLine();
        System.out.print("Role id: ");
        Role role = new Role();
        role.setId(input.nextInt());
        Zone newZone = new Zone();
        newZone.setRole(role);
        controller.update(newZone, id);
    }
}
