package ua.lviv.iot.lab_4;

import ua.lviv.iot.lab_4.view.views.GeneralView;

public class Main {
    public static void main(String[] args) {
        new Thread(Connector::new).start();
        new GeneralView().show();
    }
}
