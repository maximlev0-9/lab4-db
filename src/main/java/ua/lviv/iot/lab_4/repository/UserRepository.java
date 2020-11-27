package ua.lviv.iot.lab_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.lab_4.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
