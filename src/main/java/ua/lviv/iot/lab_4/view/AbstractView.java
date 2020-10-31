package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.business.GeneralDao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractView<T> implements View<T> {

    protected GeneralDao<T> dao;
    private final Scanner input = new Scanner(System.in);
    protected final Map<String, MenuOption> methodsMenu = new HashMap<>();
    protected String[] options;

    public void show() {
        String keyMenu;
        do {
            printMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }

    @Override
    public void printMenu() {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i+1 + " - " + options[i]);
        }
    }
}
