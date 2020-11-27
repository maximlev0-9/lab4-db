package ua.lviv.iot.lab_4.DTO;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import ua.lviv.iot.lab_4.controller.RoleController;
import ua.lviv.iot.lab_4.model.User;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
public class UserDTO extends RepresentationModel {
    private final User user;

    public UserDTO(User user, Link selfLink) {
        this.user = user;
        add(selfLink);
        add(linkTo(methodOn(RoleController.class).getRolesByUserID(user.getId())).withRel("roles"));
    }


}
