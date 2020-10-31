package ua.lviv.iot.lab_4.view;


public class GeneralView<T> extends AbstractView<T> implements View<T> {

    public GeneralView() {
        methodsMenu.put("1", () -> new UserView().show());
        options = new String[]{"users","objects", "rooms"};
    }

}
