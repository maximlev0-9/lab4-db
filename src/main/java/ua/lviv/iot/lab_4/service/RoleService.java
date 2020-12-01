package ua.lviv.iot.lab_4.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab_4.model.Role;
import ua.lviv.iot.lab_4.repository.RoleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    public List<Role> getAllRoles(){
        return repository.findAll();
    }

    public Role findById(Integer id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
