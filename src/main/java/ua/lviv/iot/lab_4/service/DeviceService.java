package ua.lviv.iot.lab_4.service;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab_4.controller.DeviceController;
import ua.lviv.iot.lab_4.exceptions.NoSuchDeviceException;
import ua.lviv.iot.lab_4.model.Device;
import ua.lviv.iot.lab_4.repository.DeviceRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@AllArgsConstructor
public class DeviceService {
    private final DeviceRepository repository;

    public ResponseEntity<CollectionModel<Device>> getAllDevices() {
        List<Device> devices = repository.findAll();
        for (Device device : devices) {
            device.add(linkTo(methodOn(DeviceController.class).getDeviceById(device.getId())).withSelfRel());
        }
        return ResponseEntity.ok(CollectionModel.of(devices, linkTo(methodOn(DeviceController.class).getAllDevices()).withSelfRel()));
    }

    public ResponseEntity<Device> findDeviceById(Integer id) {
        try {
            Device device = repository.findById(id).orElseThrow(NoSuchDeviceException::new);
            device.add(linkTo(methodOn(DeviceController.class).getDeviceById(id)).withSelfRel());
            device.add(linkTo(methodOn(DeviceController.class).getAllDevices()).withRel("all devices"));
            return ResponseEntity.ok(device);
        } catch (NoSuchDeviceException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Integer> addDevice(Device device) {
        device.setId(0);
        Device newDevice = repository.save(device);
        return ResponseEntity.ok(newDevice.getId());
    }

    public ResponseEntity<Device> updateDevice(Integer id, Device device) {
        try {
            Device oldDevice = repository.findById(id).orElseThrow(NoSuchDeviceException::new);
            device.setId(id);
            repository.save(device);
            return ResponseEntity.ok(oldDevice);
        } catch (NoSuchDeviceException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public ResponseEntity<Device> deleteById(Integer id) {
        try {
            Device device = repository.findById(id).orElseThrow(NoSuchDeviceException::new);
            repository.deleteById(id);
            return ResponseEntity.ok(device);
        } catch (NoSuchDeviceException e) {
            System.out.println("No such device");
            return ResponseEntity.notFound().build();
        }
    }

}
