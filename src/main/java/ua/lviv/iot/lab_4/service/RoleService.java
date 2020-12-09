package ua.lviv.iot.lab_4.service;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab_4.controller.RoleController;
import ua.lviv.iot.lab_4.exceptions.NoSuchRoleException;
import ua.lviv.iot.lab_4.model.Role;
import ua.lviv.iot.lab_4.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    public ResponseEntity<CollectionModel<Role>> getAllRoles(){
        List<Role> roles = repository.findAll();
        for (Role role : roles) {
            role.add(linkTo(methodOn(RoleController.class).getRoleById(role.getId())).withSelfRel());
        }
        return ResponseEntity.ok(CollectionModel.of(roles, linkTo(methodOn(RoleController.class).getAllRoles()).withSelfRel()));
    }

    public Optional<Role> findById(Integer id) {
        return repository.findById(id);
    }

    public ResponseEntity<Integer> addRole(Role role) {
        Role newRole = repository.save(role);
        newRole.add(linkTo(methodOn(RoleController.class).getRoleById(role.getId())).withSelfRel());
        return ResponseEntity.ok(newRole.getId());
    }

    public ResponseEntity<Role> updateRole(Integer id, Role role) {
        try {
            Role oldRole = repository.findById(id).orElseThrow(NoSuchRoleException::new);
            oldRole.setRole(role.getRole());
            repository.save(oldRole);
            oldRole.add(linkTo(methodOn(RoleController.class).getRoleById(oldRole.getId())).withSelfRel());
            return ResponseEntity.ok(oldRole);
        } catch (NoSuchRoleException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    public ResponseEntity<Role> deleteById(Integer id) {
        try {
            Role role = repository.findById(id).orElseThrow(NoSuchRoleException::new);
            repository.deleteById(id);
            role.add(linkTo(methodOn(RoleController.class).getAllRoles()).withRel("all roles"));
            return ResponseEntity.ok(role);
        } catch (NoSuchRoleException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
