package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.dao.impl.UserDaoImpl;
import ua.lviv.iot.lab_4.model.Role;
import ua.lviv.iot.lab_4.model.User;

public class UserView extends AbstractView<User> {

    public UserView() {
        super(new UserDaoImpl());
    }

    @Override
    protected void addNewObject() {
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

    @Override
    protected void deleteObject() {
        System.out.println("Enter id of user to be deleted: ");
        int id = input.nextInt();
        String response = controller.deleteById(id) ? "Deleted successfully" : "Oops, something gone wrong";
        System.out.println(response);
    }

    @Override
    protected void updateObject() {
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
}
