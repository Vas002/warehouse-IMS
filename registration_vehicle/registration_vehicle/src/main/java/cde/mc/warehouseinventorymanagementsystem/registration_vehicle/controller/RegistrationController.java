package cde.mc.warehouseinventorymanagementsystem.registration_vehicle.controller;

import cde.mc.warehouseinventorymanagementsystem.registration_vehicle.service.RegistrationService;
import cde.mc.warehouseinventorymanagementsystem.registration_vehicle.entity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/registration")
public class RegistrationController {


    @Autowired
    private RegistrationService registrationService;
    @Value("${spring.application.name:no name}")
    private String appName;
    @Value("${server.port:no port}")
    private String port;


    @GetMapping("/login")
    public String processForm(@RequestParam String Username, String password){
        String message =   registrationService.validate(Username,password);
        return message;
    }

    @PostMapping("/register")
    public String vehicle(@Validated @RequestBody Registration registration) {
        registrationService.vehicle(registration);
        return "Registered successfully ";

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleMethodArguments(MethodArgumentNotValidException e){
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error->errors.put(error.getField(),error.getDefaultMessage()));
        return errors;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,String> noSuchElementException(NoSuchElementException ee){
        Map<String,String> errors = new HashMap<>();
        errors.put("me",ee.getMessage());
        return errors;
    }
    @GetMapping("/location")
    public String getVehicleRegistrationLocation(){
        return appName + " : " + port;
    }


}
