package ua.lviv.iot.lab_4.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_4.model.Address;
import ua.lviv.iot.lab_4.service.AddressService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService service;

    @GetMapping
    public ResponseEntity<CollectionModel<Address>> getAllAddresses() {
        return service.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Integer id) {
        return service.findAddressById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addAddress(@RequestBody Address address) {
        return service.addAddress(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") Integer id, @RequestBody Address address) {
        return service.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }
}
