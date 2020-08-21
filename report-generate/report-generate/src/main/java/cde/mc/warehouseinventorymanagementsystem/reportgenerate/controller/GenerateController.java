package cde.mc.warehouseinventorymanagementsystem.reportgenerate.controller;

import cde.mc.warehouseinventorymanagementsystem.reportgenerate.entity.Activity;
import cde.mc.warehouseinventorymanagementsystem.reportgenerate.service.GenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/generate")
public class GenerateController {

    @Autowired
    private GenerateService generateService;

    @Value("${spring.application.name:no name}")
    private String appName;
    @Value("${server.port:no port}")
    private String port;


    @GetMapping("/byActivity")
    public List<Activity> reportGenerationByActivity(@RequestParam String activity){
        List<Activity>active=generateService.reportGenerationByActivity(activity);
        return active;
    }

    @GetMapping("/bycapacityandmonth")
    public List<Activity>reportGenerationByCapacityAndMonth(@RequestParam Integer capacity,Integer month){
        List<Activity>activities=generateService.reportGenerationByCapacityAndMonth(capacity,month);
        return activities;
    }
    @GetMapping("/byactivityandyear")
    public List<Activity>reportGenerationByActivityAndyear(@RequestParam String activity, Integer year){
        List<Activity>activityList=generateService.reportGenerationByActivityAndyear(activity,year);
        return activityList;
    }


    @GetMapping("/location")
    public String getVehicleRegistrationLocation(){
        return appName + " : " + port;
    }


}
