package cde.mc.warehouseinventorymanagementsystem.registration_vehicle.repository;

import cde.mc.warehouseinventorymanagementsystem.registration_vehicle.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,String> {
    @Query(value = "select * from registration toa where toa.Username =? And toa.password =?",nativeQuery = true)
     Registration findByUserName(String Username,String password);
}
