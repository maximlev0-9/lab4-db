package ua.lviv.iot.lab_4.service;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.lab_4.controller.RoomController;
import ua.lviv.iot.lab_4.exceptions.NoSuchRoomException;
import ua.lviv.iot.lab_4.model.Room;
import ua.lviv.iot.lab_4.repository.RoomRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@AllArgsConstructor
public class RoomService {
    private final RoomRepository repository;

    public ResponseEntity<CollectionModel<Room>> getAllRooms() {
        List<Room> rooms = repository.findAll();
        for (Room room : rooms) {
            room.add(linkTo(methodOn(RoomController.class).getRoomById(room.getId())).withSelfRel());
        }
        return ResponseEntity.ok(CollectionModel.of(rooms, linkTo(methodOn(RoomController.class).getAllRooms()).withSelfRel()));
    }

    public ResponseEntity<Room> findRoomById(Integer id) {
        try {
            Room Room = repository.findById(id).orElseThrow(NoSuchRoomException::new);
            Room.add(linkTo(methodOn(RoomController.class).getRoomById(id)).withSelfRel());
            Room.add(linkTo(methodOn(RoomController.class).getAllRooms()).withRel("all Rooms"));
            return ResponseEntity.ok(Room);
        } catch (NoSuchRoomException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Integer> addRoom(Room room) {
        Room newRoom = repository.save(room);
        return ResponseEntity.ok(newRoom.getId());
    }

    public ResponseEntity<Room> updateRoom(Integer id, Room room) {
        try {
            Room oldRoom = repository.findById(id).orElseThrow(NoSuchRoomException::new);
            room.setId(id);
            repository.save(room);
            return ResponseEntity.ok(oldRoom);
        } catch (NoSuchRoomException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    public ResponseEntity<Room> deleteById(Integer id) {
        try {
            Room room = repository.findById(id).orElseThrow(NoSuchRoomException::new);
            repository.deleteById(id);
            return ResponseEntity.ok(room);
        } catch (NoSuchRoomException e) {
            e.printStackTrace();
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
