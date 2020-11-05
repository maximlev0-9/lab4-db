package ua.lviv.iot.lab_4.view;


public class GeneralView<T> extends AbstractView<T> implements View<T> {

    public GeneralView() {
        super(new String[]{"Users", "Objects", "Rooms", "Roles", "Devices"}, null);
        methodsMenu.put("1", () -> new UserView().show());
        methodsMenu.put("4", () -> new RoleView().show());
    }

}
