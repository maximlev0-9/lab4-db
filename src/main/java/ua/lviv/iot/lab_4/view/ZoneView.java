package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.dao.impl.ZoneDaoImpl;
import ua.lviv.iot.lab_4.model.Zone;

public class ZoneView extends AbstractView<Zone> {
    public ZoneView() {
        super(new ZoneDaoImpl());
    }

    @Override
    protected void addNewObject() {
        Zone newZone = new Zone();
        System.out.println("Enter it's params:");
        System.out.print("Role: ");
        newZone.setRoleId(input.nextInt());
        controller.save(newZone);
        System.out.println("Saved successfully");
    }

    @Override
    protected void deleteObject() {
        System.out.print("Enter id of role to be deleted: ");
        int id = input.nextInt();
        String response = controller.deleteById(id) ? "Deleted successfully" : "Oops, something gone wrong";
        System.out.println(response);
    }

    @Override
    protected void updateObject() {
        System.out.print("Enter id of zone to be updated: ");
        int id = input.nextInt();
        System.out.println("Enter it's params: ");
        input.nextLine();
        System.out.print("Role id: ");
        int role = input.nextInt();
        Zone newZone = new Zone();
        newZone.setRoleId(role);
        controller.update(newZone, id);
    }
}
