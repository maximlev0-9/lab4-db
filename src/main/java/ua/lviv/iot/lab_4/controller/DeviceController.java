package ua.lviv.iot.lab_4.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_4.model.Device;
import ua.lviv.iot.lab_4.service.DeviceService;

@RestController
@RequestMapping("/device")
@AllArgsConstructor
public class DeviceController {
    private final DeviceService service;

    @GetMapping
    public ResponseEntity<CollectionModel<Device>> getAllDevices() {
        return service.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") Integer id) {
        return service.findDeviceById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addDevice(@RequestBody Device device) {
        return service.addDevice(device);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable("id") Integer id, @RequestBody Device device) {
        return service.updateDevice(id, device);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Device> deleteDevice(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }
}
