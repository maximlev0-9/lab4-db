package ua.lviv.iot.lab_4.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_4.model.Zone;
import ua.lviv.iot.lab_4.service.ZoneService;

@RestController
@RequestMapping("/zone")
@AllArgsConstructor
public class ZoneController {
    private final ZoneService service;

    @GetMapping
    public ResponseEntity<CollectionModel<Zone>> getAllZones() {
        return service.getAllZones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zone> getZoneById(@PathVariable("id") Integer id) {
        return service.findZoneById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addZone(@RequestBody Zone zone) {
        return service.addZone(zone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zone> updateZone(@PathVariable("id") Integer id, @RequestBody Zone zone) {
        return service.updateZone(id, zone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Zone> deleteZone(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }
}
