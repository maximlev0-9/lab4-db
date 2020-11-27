package ua.lviv.iot.lab_4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.lab_4.model.Role;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @GetMapping("/by-user-id/{id}")
    public ResponseEntity<List<Role>> getRolesByUserID(@PathVariable("id") int id){
        return ResponseEntity.ok(new ArrayList<>());
    }
}
