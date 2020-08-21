package cde.mc.warehouseinventorymanagementsystem.reportgenerate.service;

import cde.mc.warehouseinventorymanagementsystem.reportgenerate.entity.Activity;
import cde.mc.warehouseinventorymanagementsystem.reportgenerate.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenerateService {

    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> reportGenerationByActivity( String activity){
        List<Activity>active=activityRepository.findByActivityType(activity);
        return active;
    }
    public List<Activity>reportGenerationByCapacityAndMonth( Integer capacity,Integer month){
        List<Activity>activities=activityRepository.findByCapacityAndMonth(capacity,month) ;
        return activities;
    }
    public List<Activity>reportGenerationByActivityAndyear( String activity, Integer year){
        List<Activity>activityList=activityRepository.findByActivityTypeAndYear(activity,year);
        return activityList;
    }
}
