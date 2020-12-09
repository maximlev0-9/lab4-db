package ua.lviv.iot.lab_4.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_4.exceptions.NoSuchRoleException;
import ua.lviv.iot.lab_4.model.Role;
import ua.lviv.iot.lab_4.service.RoleService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        try {
            Role role = service.findById(id).orElseThrow(NoSuchRoleException::new);
            role.add(linkTo(methodOn(this.getClass()).getRoleById(id)).withSelfRel());
            role.add(linkTo(methodOn(this.getClass()).getAllRoles()).withRel("all roles"));
            return ResponseEntity.ok(role);
        } catch (NoSuchRoleException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
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
