package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.dao.impl.RoleDaoImpl;
import ua.lviv.iot.lab_4.model.Role;

public class RoleView extends AbstractView<Role> {

    public RoleView() {
        super(new String[]{"Find all roles", "Add new role", "Delete role", "Update existing role"}, new RoleDaoImpl());
        methodsMenu.put("1", this::findAllRoles);
        methodsMenu.put("2", this::addNewRole);
        methodsMenu.put("3", this::deleteRole);
        methodsMenu.put("4", this::updateRole);
    }

    private void updateRole() {
        System.out.print("Enter id of role to be updated: ");
        int id = input.nextInt();
        System.out.print("Enter it's role: ");
        String role = input.nextLine();
        Role newRole = new Role();
        newRole.setRole(role);
        controller.update(newRole, id);
    }

    private void deleteRole() {
        System.out.print("Enter id of role to be deleted: ");
        int id = input.nextInt();
        String response = controller.deleteById(id) ? "Deleted successfully" : "Oops, something gone wrong";
        System.out.println(response);
    }

    private void addNewRole() {
        Role newRole = new Role();
        System.out.println("Enter it's params:");
        System.out.print("Role: ");
        newRole.setRole(input.nextLine());
        controller.save(newRole);
        System.out.println("Saved successfully");
    }

    private void findAllRoles() {
        System.out.println(controller.findAll());
    }
}
