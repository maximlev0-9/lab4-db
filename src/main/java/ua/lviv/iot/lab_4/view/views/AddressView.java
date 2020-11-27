package ua.lviv.iot.lab_4.view.views;

import ua.lviv.iot.lab_4.controller.AddressController;
import ua.lviv.iot.lab_4.model.Address;

public class AddressView extends AbstractView<Address> {
    public AddressView() {
        super(new AddressController());
    }

    @Override
    protected void addNewObject() {
        Address newAddress = new Address();
        System.out.println("Enter it's params:");
        System.out.print("Country: ");
        input.nextLine();
        newAddress.setCountry(input.nextLine());
        System.out.print("City: ");
        newAddress.setCity(input.nextLine());
        System.out.print("Street: ");
        newAddress.setStreet(input.nextLine());
        System.out.print("Building number: ");
        newAddress.setBuildingNumber(input.nextInt());
        System.out.print("Flat number: ");
        newAddress.setFlatNumber(input.nextInt());
        controller.save(newAddress);
        System.out.println("Saved successfully");
    }

    @Override
    protected void updateObject() {
        System.out.print("Enter id of object to be updated: ");
        int id = input.nextInt();
        Address newAddress = new Address();
        System.out.println("Enter it's params:");
        System.out.print("Country: ");
        newAddress.setCountry(input.nextLine());
        System.out.print("City: ");
        newAddress.setCity(input.nextLine());
        System.out.print("Street: ");
        newAddress.setStreet(input.nextLine());
        System.out.print("Building number: ");
        newAddress.setBuildingNumber(input.nextInt());
        System.out.print("Flat number: ");
        newAddress.setFlatNumber(input.nextInt());
        controller.update(newAddress, id);
        System.out.println("Updated successfully");

    }
}
