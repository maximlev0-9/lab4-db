package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.dao.GeneralDao;
import ua.lviv.iot.lab_4.model.Address;

// working
public class AddressDaoImpl extends AbstractGeneralDao<Address> implements GeneralDao<Address> {
    public AddressDaoImpl() {
        super(Address.class);
    }
}
