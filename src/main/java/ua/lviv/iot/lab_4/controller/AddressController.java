package ua.lviv.iot.lab_4.controller;

import ua.lviv.iot.lab_4.dao.impl.AddressDaoImpl;
import ua.lviv.iot.lab_4.model.Address;

public class AddressController extends GeneralController<Address> {

    public AddressController() {
        super(new AddressDaoImpl());
    }
}
