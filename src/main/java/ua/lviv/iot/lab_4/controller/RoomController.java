package ua.lviv.iot.lab_4.controller;

import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.lab_4.model.Room;
import ua.lviv.iot.lab_4.service.RoomService;

@RestController
@RequestMapping("/room")
@AllArgsConstructor
public class RoomController {
    private final RoomService service;

    @GetMapping
    public ResponseEntity<CollectionModel<Room>> getAllRooms() {
        return service.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id) {
        return service.findRoomById(id);
    }

    @PostMapping
    public ResponseEntity<Integer> addRoom(@RequestBody Room room) {
        return service.addRoom(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable("id") Integer id, @RequestBody Room room) {
        return service.updateRoom(id, room);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }
}
