package ua.lviv.iot.lab_4.view;

import ua.lviv.iot.lab_4.dao.impl.ZoneDaoImpl;
import ua.lviv.iot.lab_4.model.Zone;

public class ZoneView extends AbstractView<Zone> {
    public ZoneView() {
        super(new ZoneDaoImpl());

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
