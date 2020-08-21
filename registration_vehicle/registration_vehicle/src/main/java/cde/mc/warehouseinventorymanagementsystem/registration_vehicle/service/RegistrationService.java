package cde.mc.warehouseinventorymanagementsystem.registration_vehicle.service;


import cde.mc.warehouseinventorymanagementsystem.registration_vehicle.repository.RegistrationRepository;
import cde.mc.warehouseinventorymanagementsystem.registration_vehicle.entity.Registration;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RegistrationService {


    @Autowired
    private RegistrationRepository registrationRepository;

    public String validate(String Username,String password){
       Registration registration=registrationRepository.findByUserName(Username,password);
       if(registration !=null){
           return "login successfully";
       }
        throw new NoSuchElementException("Username not found");
    }


    public Registration vehicle( Registration registration){
       return registrationRepository.save(registration);
    }


}
