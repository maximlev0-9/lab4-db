package ua.lviv.iot.lab_4.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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


    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = service.getAllRoles();
        Link link = linkTo(methodOn(this.getClass()).getAllRoles()).withSelfRel();
        for (Role role : roles) {
            Link selfLink = Link.of(link.getHref() + "/" + role.getId()).withSelfRel();
            role.add(selfLink);
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Integer id) {
        Role role = service.findById(id);
        role.add(linkTo(methodOn(this.getClass()).getRoleById(id)).withSelfRel());
        role.add(linkTo(methodOn(this.getClass()).getAllRoles()).withRel("all roles"));
        return ResponseEntity.ok(role);
    }
}
