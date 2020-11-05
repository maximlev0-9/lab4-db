package ua.lviv.iot.lab_4.view;

public class GeneralView<T> extends AbstractView<T> implements View<T> {

    public GeneralView() {
        super(new String[]{"Users", "Objects", "Devices", "Rooms", "Roles", "Zones"});
        methodsMenu.put("1", () -> new UserView().show());
        methodsMenu.put("4", () -> new RoomView().show());
        methodsMenu.put("5", () -> new RoleView().show());
        methodsMenu.put("6", () -> new ZoneView().show());
    }

    @Override
    protected void addNewObject() {
    }

    @Override
    protected void deleteObject() {
    }

    @Override
    protected void updateObject() {
    }
}
