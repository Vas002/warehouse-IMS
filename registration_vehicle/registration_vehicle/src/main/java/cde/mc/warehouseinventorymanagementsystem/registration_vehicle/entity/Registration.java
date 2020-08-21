package cde.mc.warehouseinventorymanagementsystem.registration_vehicle.entity;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Registration {

    @Id
    @Column(unique=true)
    @NotBlank(message = "Username should not be blank")
    private String Username;

    @NotBlank(message = "password should not be blank")
    private String password;
    @NotBlank(message = "address should not be blank")
    private String address;

    @Column(unique=true)
    @NotBlank(message = "DrivingLicense should not be Null")
    private String DrivingLicenseNumber;

    @Column(unique=true)
    @NotBlank(message = "VehicleNumber should not be Null")
    private String VehicleNumber;
    @NotNull(message = "VehicleType should not be Null")
    private String VehicleType;
    @NotNull(message = "VehicleCapacity should not be Null")
    private Integer VehicleCapacity;

    public Registration(){}

    public Registration(String username, String password, String address, String drivingLicenseNumber, String vehicleNumber, String vechileType, Integer vechileCapacity) {
        Username = username;
        this.password = password;
        this.address = address;
        DrivingLicenseNumber = drivingLicenseNumber;
        VehicleNumber = vehicleNumber;
        VehicleType = vechileType;
        VehicleCapacity = vechileCapacity;
    }
}



