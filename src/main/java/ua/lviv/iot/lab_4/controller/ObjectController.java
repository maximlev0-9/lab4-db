package ua.lviv.iot.lab_4.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_4.model.MyObject;
import ua.lviv.iot.lab_4.service.ObjectService;

@RestController
@RequestMapping("/object")
@AllArgsConstructor
public class ObjectController {
    private final ObjectService service;

    @GetMapping
    public ResponseEntity<CollectionModel<MyObject>> getAllObjects() {
        return service.getAllObjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyObject> getObjectById(@PathVariable("id") Integer id) {
        return service.findObjectById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addObject(@RequestBody MyObject object) {
        return service.addObject(object);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyObject> updateObject(@PathVariable("id") Integer id, @RequestBody MyObject object) {
        return service.updateObject(id, object);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MyObject> deleteObject(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }
}
