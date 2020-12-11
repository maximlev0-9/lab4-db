package ua.lviv.iot.lab_4.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_4.model.Role;
import ua.lviv.iot.lab_4.service.RoleService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    private final RoleService service;


    @GetMapping
    public ResponseEntity<CollectionModel<Role>> getAllRoles() {
        return service.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Integer id) {
        return service.getRoleById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addRole(@RequestBody Role role) {
        return service.addRole(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") Integer id, @RequestBody Role role) {
        return service.updateRole(id, role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable("id") Integer id){
        return service.deleteById(id);
    }
}
