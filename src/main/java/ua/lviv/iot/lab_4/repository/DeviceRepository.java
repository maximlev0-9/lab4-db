package ua.lviv.iot.lab_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.lab_4.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
