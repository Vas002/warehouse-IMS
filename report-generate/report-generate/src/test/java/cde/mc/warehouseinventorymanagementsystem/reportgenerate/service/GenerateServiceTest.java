package cde.mc.warehouseinventorymanagementsystem.reportgenerate.service;

import cde.mc.warehouseinventorymanagementsystem.reportgenerate.entity.Activity;
import cde.mc.warehouseinventorymanagementsystem.reportgenerate.repository.ActivityRepository;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GenerateServiceTest {
   @Mock
    private ActivityRepository activityRepository;

    private GenerateService generateService;

    @Before
    public void init()
    {
        generateService = new GenerateService(activityRepository);

    }


    private List<Activity> mocklist() {
        Activity userRegister = new Activity();
        userRegister.setUsername("mayank");
        userRegister.setVehicleNumber("1313");
        userRegister.setVehicleType("bus");
        userRegister.setActivity("loading");
        userRegister.setCapacity(77);
        userRegister.setActivityTimestamp(LocalDate.now());
        List<Activity> activities = new ArrayList<>();
        activities.add(userRegister);
        return activities;
    }
        @Test
        public void findByActivityType(){

            when(activityRepository.findByActivityType("loading")).thenReturn(mocklist());
            List<Activity> response = generateService.reportGenerationByActivity("loading");
            assertEquals(1,response.size());

    }
    @Test(expected = NoSuchElementException.class)
    public void findByActivityType_exception(){

        when(activityRepository.findByActivityType("loading")).thenThrow(NoSuchElementException.class);
        List<Activity> response = generateService.reportGenerationByActivity("loading");


    }
    @Test
    public void reportGenerationByActivityAndyear(){

        when(activityRepository.findByActivityTypeAndYear("loading",2020)).thenReturn(mocklist());
        List<Activity> result=generateService.reportGenerationByActivityAndyear("loading",2020);
        assertEquals(1,result.size());
    }
    @Test(expected=NoSuchElementException.class)
    public void reportGenerationByActivityAndyear_exception(){

        when(activityRepository.findByActivityTypeAndYear("loading",2020)).thenThrow(NoSuchElementException.class);
        List<Activity> result=generateService.reportGenerationByActivityAndyear("loading",2020);

    }

    @Test
    public void reportGenerationByCapacityAndMonth(){

        when(activityRepository.findByCapacityAndMonth(77,8)).thenReturn(mocklist());
        List<Activity> report=generateService.reportGenerationByCapacityAndMonth(77,8);
        assertEquals(1,report.size());
    }
    @Test(expected = NoSuchElementException.class)
    public void reportGenerationByCapacityAndMonth_exception(){

        when(activityRepository.findByCapacityAndMonth(77,8)).thenThrow(NoSuchElementException.class);
        List<Activity> report=generateService.reportGenerationByCapacityAndMonth(77,8);
        assertEquals(1,report.size());
    }

}
