package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.dao.impl.UserDaoImpl;
import ua.lviv.iot.lab_4.model.Role;
import ua.lviv.iot.lab_4.model.User;

public class UserView extends AbstractView<User> {

    public UserView() {
        super(new String[]{"List all users",
                "Add new user", "Delete user", "Update user"}, new UserDaoImpl());
        methodsMenu.put("1", this::findAllUsers);
        methodsMenu.put("2", this::addNewUser);
        methodsMenu.put("3", this::deleteUser);
        methodsMenu.put("4", this::updateUser);
    }

    private void findAllUsers() {
        System.out.println(controller.findAll());
    }

    private void updateUser() {
        System.out.println("Enter id of user to be updated: ");
        int id = input.nextInt();
        User oldUser = controller.findOne(id);
        User newUser = new User();
        System.out.println("Enter new params (leave blank to not change param):");
        System.out.print("Name: ");
        input.nextLine();
        String name = input.nextLine();
        newUser.setName(name.isEmpty() ? oldUser.getName() : name);
        System.out.print("Gender: ");
        String gender = input.nextLine();
        newUser.setGender(gender.isEmpty() ? oldUser.getGender() : gender);
        System.out.print("Age: ");
        String age = input.nextLine();
        newUser.setAge(age.isEmpty() ? oldUser.getAge() : Byte.parseByte(age));
        System.out.print("Role id: ");
        String roleId = input.nextLine();
        Role role;
        if (roleId.isEmpty()) {
            role = oldUser.getRoleId();
        } else {
            role = new Role();
            role.setId(Integer.parseInt(roleId));
        }

        newUser.setRoleId(role);
        controller.update(newUser, id);
        System.out.println("Saved successfully");
    }

    private void deleteUser() {
        System.out.println("Enter id of user to be deleted: ");
        int id = input.nextInt();
        String response = controller.deleteById(id) ? "Deleted successfully" : "Oops, something gone wrong";
        System.out.println(response);
    }

    private void addNewUser() {
        User newUser = new User();
        System.out.println("Enter it's params:");
        System.out.print("Name: ");
        newUser.setName(input.nextLine());
        System.out.print("Gender: ");
        newUser.setGender(input.nextLine());
        System.out.print("Age: ");
        newUser.setAge(input.nextByte());
        System.out.print("Role id: ");
        Role role = new Role();
        role.setId(input.nextInt());
        newUser.setRoleId(role);
        controller.save(newUser);
        System.out.println("Saved successfully");
    }
}
