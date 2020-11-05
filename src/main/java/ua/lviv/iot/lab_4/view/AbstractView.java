package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.controller.Controller;
import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractView<T> implements View<T> {

    protected final Map<String, MenuOption> methodsMenu = new HashMap<>();
    protected final Scanner input = new Scanner(System.in);
    protected final Controller<T> controller;
    protected final String[] options;

    public AbstractView(String[] options, AbstractGeneralDao<T> dao) {
        this.options = options;
        this.controller = new Controller<>(dao);
    }

    public void show() {
        String keyMenu;
        do {
            printMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).execute();
            } catch (Exception e) {
                //todo: fix that
//                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }

    @Override
    public void printMenu() {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + " - " + options[i]);
        }
    }
}
