package ua.lviv.iot.lab_4.view.views;

import ua.lviv.iot.lab_4.controller.Controller;
import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.view.MenuOption;
import ua.lviv.iot.lab_4.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractView<T> implements View<T> {

    protected final Map<String, MenuOption> methodsMenu = new HashMap<>();
    protected final Scanner input = new Scanner(System.in);
    protected final Controller<T> controller;
    protected final String[] options;
    protected final String nameOfTable;

    public AbstractView(AbstractGeneralDao<T> dao) {
        this.controller = new Controller<>(dao);
        nameOfTable = dao.getNameOfTable();
        this.options = new String[]{
                "Find all " + nameOfTable + "s",
                "Add new " + nameOfTable,
                "Delete " + nameOfTable,
                "Update existing " + nameOfTable};

        methodsMenu.put("1", this::findAllObjects);
        methodsMenu.put("2", this::addNewObject);
        methodsMenu.put("3", this::deleteObject);
        methodsMenu.put("4", this::updateObject);
    }

    public AbstractView(String[] options) {
        this.options = options;
        this.nameOfTable = "";
        this.controller = new Controller<>(null);
    }

    protected void findAllObjects() {
        System.out.println(controller.findAll());
    }

    protected abstract void addNewObject();

    protected void deleteObject() {
        System.out.println("Enter id of " + nameOfTable + " to be deleted: ");
        int id = input.nextInt();
        String response = controller.deleteById(id) ? "Deleted successfully" : "Oops, something gone wrong";
        System.out.println(response);
    }

    protected abstract void updateObject();

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
