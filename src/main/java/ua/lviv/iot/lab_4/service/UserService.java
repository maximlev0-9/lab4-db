package ua.lviv.iot.lab_4.service;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab_4.controller.UserController;
import ua.lviv.iot.lab_4.exceptions.NoSuchUserException;
import ua.lviv.iot.lab_4.model.User;
import ua.lviv.iot.lab_4.repository.UserRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    public ResponseEntity<CollectionModel<User>> getAllUsers() {
        List<User> users = repository.findAll();
        for (User user : users) {
            user.add(linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel());
        }
        return ResponseEntity.ok(CollectionModel.of(users, linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel()));
    }

    public ResponseEntity<User> getUserById(Integer id) {
        try {
            User user = repository.findById(id).orElseThrow(NoSuchUserException::new);
            user.add(linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel());
            return ResponseEntity.ok(user);
        } catch (NoSuchUserException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Integer> addUser(User user) {
        User newUser = repository.save(user);
        return ResponseEntity.ok(newUser.getId());
    }

    public ResponseEntity<User> updateUser(Integer id, User user) {
        try {
            if (repository.existsById(id)) {
                user.setId(id);
                repository.save(user);
                return ResponseEntity.ok(user);
            } else {
                throw new NoSuchUserException();
            }
        } catch (NoSuchUserException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> deleteById(Integer id) {
        try {
            if (repository.existsById(id)) {
                User user = repository.getOne(id);
                repository.deleteById(id);
                return ResponseEntity.ok(user);
            } else {
                throw new NoSuchUserException();
            }
        } catch (NoSuchUserException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}

