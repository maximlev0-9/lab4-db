package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.business.impl.UserDaoImpl;
import ua.lviv.iot.lab_4.model.User;

public class UserView extends AbstractView<User> {

    public UserView() {
        dao = new UserDaoImpl();
        options = new String[]{"list all users",
                "add new user", "delete user"};
        methodsMenu.put("1", () -> System.out.println(dao.findAll()));
    }

}
