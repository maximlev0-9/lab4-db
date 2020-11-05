package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.dao.impl.RoleDaoImpl;
import ua.lviv.iot.lab_4.model.Role;

public class RoleView extends AbstractView<Role> {

    public RoleView() {
        super(new RoleDaoImpl());
    }

    @Override
    protected void addNewObject() {
        Role newRole = new Role();
        System.out.println("Enter it's params:");
        System.out.print("Role: ");
        newRole.setRole(input.nextLine());
        controller.save(newRole);
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
        System.out.print("Enter id of role to be updated: ");
        int id = input.nextInt();
        System.out.print("Enter it's role: ");
        input.nextLine();
        String role = input.nextLine();
        Role newRole = new Role();
        newRole.setRole(role);
        controller.update(newRole, id);
    }
}
