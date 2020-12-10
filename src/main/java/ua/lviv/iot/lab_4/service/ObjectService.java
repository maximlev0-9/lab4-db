package ua.lviv.iot.lab_4.service;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab_4.controller.ObjectController;
import ua.lviv.iot.lab_4.exceptions.NoSuchObjectException;
import ua.lviv.iot.lab_4.model.MyObject;
import ua.lviv.iot.lab_4.repository.ObjectRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@AllArgsConstructor
public class ObjectService {
    private final ObjectRepository repository;

    public ResponseEntity<CollectionModel<MyObject>> getAllObjects() {
        List<MyObject> objects = repository.findAll();
        for (MyObject object : objects) {
            object.add(linkTo(methodOn(ObjectController.class).getObjectById(object.getId())).withSelfRel());
        }
        return ResponseEntity.ok(CollectionModel.of(objects, linkTo(methodOn(ObjectController.class).getAllObjects()).withSelfRel()));
    }

    public ResponseEntity<MyObject> findObjectById(Integer id) {
        try {
            MyObject myObject = repository.findById(id).orElseThrow(NoSuchObjectException::new);
            myObject.add(linkTo(methodOn(ObjectController.class).getObjectById(id)).withSelfRel());
            myObject.add(linkTo(methodOn(ObjectController.class).getAllObjects()).withRel("all Objects"));
            return ResponseEntity.ok(myObject);
        } catch (NoSuchObjectException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Integer> addObject(MyObject object) {
        MyObject newObject = repository.save(object);
        return ResponseEntity.ok(newObject.getId());
    }

    public ResponseEntity<MyObject> updateObject(Integer id, MyObject object) {
        try {
            MyObject oldObject = repository.findById(id).orElseThrow(NoSuchObjectException::new);
            object.setId(id);
            repository.save(object);
            return ResponseEntity.ok(oldObject);
        } catch (NoSuchObjectException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    public ResponseEntity<MyObject> deleteById(Integer id) {
        try {
            MyObject object = repository.findById(id).orElseThrow(NoSuchObjectException::new);
            repository.deleteById(id);
            return ResponseEntity.ok(object);
        } catch (NoSuchObjectException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}

