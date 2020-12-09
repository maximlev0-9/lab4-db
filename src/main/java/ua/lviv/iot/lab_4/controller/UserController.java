package ua.lviv.iot.lab_4.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_4.model.User;
import ua.lviv.iot.lab_4.service.UserService;

@RestController()
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService service;


    @GetMapping
    public ResponseEntity<CollectionModel<User>> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        return service.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }
}
