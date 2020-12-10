package ua.lviv.iot.lab_4.service;


import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab_4.controller.AddressController;
import ua.lviv.iot.lab_4.exceptions.NoSuchAddressException;
import ua.lviv.iot.lab_4.model.Address;
import ua.lviv.iot.lab_4.repository.AddressRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository repository;

    public ResponseEntity<CollectionModel<Address>> getAllAddresses() {
        List<Address> addresses = repository.findAll();
        for (Address address : addresses) {
            address.add(linkTo(methodOn(AddressController.class).getAddressById(address.getId())).withSelfRel());
        }
        return ResponseEntity.ok(CollectionModel.of(addresses, linkTo(methodOn(AddressController.class).getAllAddresses()).withSelfRel()));
    }

    public ResponseEntity<Address> findAddressById(Integer id) {
        try {
            Address address = repository.findById(id).orElseThrow(NoSuchAddressException::new);
            address.add(linkTo(methodOn(AddressController.class).getAddressById(id)).withSelfRel());
            address.add(linkTo(methodOn(AddressController.class).getAllAddresses()).withRel("all addresses"));
            return ResponseEntity.ok(address);
        } catch (NoSuchAddressException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Integer> addAddress(Address address) {
        Address newAddress = repository.save(address);
        return ResponseEntity.ok(newAddress.getId());
    }

    public ResponseEntity<Address> updateAddress(Integer id, Address address) {
        try {
            Address oldAddress = repository.findById(id).orElseThrow(NoSuchAddressException::new);
            address.setId(id);
            repository.save(address);
            return ResponseEntity.ok(oldAddress);
        } catch (NoSuchAddressException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    public ResponseEntity<Address> deleteById(Integer id) {
        try {
            Address address = repository.findById(id).orElseThrow(NoSuchAddressException::new);
            repository.deleteById(id);
            return ResponseEntity.ok(address);
        } catch (NoSuchAddressException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
