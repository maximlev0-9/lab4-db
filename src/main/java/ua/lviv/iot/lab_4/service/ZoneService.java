package ua.lviv.iot.lab_4.service;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab_4.controller.RoleController;
import ua.lviv.iot.lab_4.controller.ZoneController;
import ua.lviv.iot.lab_4.exceptions.NoSuchZoneException;
import ua.lviv.iot.lab_4.model.Zone;
import ua.lviv.iot.lab_4.repository.ZoneRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@AllArgsConstructor
public class ZoneService {
    private final ZoneRepository repository;

    public ResponseEntity<CollectionModel<Zone>> getAllZones() {
        List<Zone> zones = repository.findAll();
        for (Zone zone : zones) {
            zone.add(linkTo(methodOn(ZoneController.class).getZoneById(zone.getId())).withSelfRel());
            zone.getRole().add(linkTo(methodOn(RoleController.class).getRoleById(zone.getRole().getId())).withSelfRel());
        }
        return ResponseEntity.ok(CollectionModel.of(zones, linkTo(methodOn(ZoneController.class).getAllZones()).withSelfRel()));
    }

    public ResponseEntity<Zone> findZoneById(Integer id) {
        try {
            Zone zone = repository.findById(id).orElseThrow(NoSuchZoneException::new);
            zone.add(linkTo(methodOn(ZoneController.class).getZoneById(id)).withSelfRel());
            zone.add(linkTo(methodOn(ZoneController.class).getAllZones()).withRel("all Zones"));
            return ResponseEntity.ok(zone);
        } catch (NoSuchZoneException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Integer> addZone(Zone zone) {
        Zone newZone = repository.save(zone);
        return ResponseEntity.ok(newZone.getId());
    }

    public ResponseEntity<Zone> updateZone(Integer id, Zone zone) {
        try {
            Zone oldZone = repository.findById(id).orElseThrow(NoSuchZoneException::new);
            zone.setId(id);
            repository.save(zone);
            return ResponseEntity.ok(oldZone);
        } catch (NoSuchZoneException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    public ResponseEntity<Zone> deleteById(Integer id) {
        try {
            Zone zone = repository.findById(id).orElseThrow(NoSuchZoneException::new);
            repository.deleteById(id);
            return ResponseEntity.ok(zone);
        } catch (NoSuchZoneException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
