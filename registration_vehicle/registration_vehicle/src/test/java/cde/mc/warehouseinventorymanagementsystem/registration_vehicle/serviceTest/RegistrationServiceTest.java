package cde.mc.warehouseinventorymanagementsystem.registration_vehicle.serviceTest;


import cde.mc.warehouseinventorymanagementsystem.registration_vehicle.entity.Registration;
import cde.mc.warehouseinventorymanagementsystem.registration_vehicle.repository.RegistrationRepository;
import cde.mc.warehouseinventorymanagementsystem.registration_vehicle.service.RegistrationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RegistrationServiceTest {

    @Mock
    private RegistrationRepository registrationRepository;
@Autowired
    private RegistrationService registrationService;

    @Before
    public void init()
    {
        registrationService = mock(RegistrationService.class);
        registrationService = new RegistrationService(registrationRepository);
    }

    @Test
    public void testvalidate()
    {
        Mockito.when(registrationRepository.findByUserName("vishal", "12345"))
                .thenReturn(mockRegistration());
        String response = registrationService.validate("vishal", "12345");

        Assert.assertEquals("login successfully", response);
    }
    @Test(expected= NoSuchElementException.class)
    public void testvalidate_exception()
    {
        Mockito.when(registrationRepository.findByUserName("vishal", "12345"))
                .thenThrow(NoSuchElementException.class);
        String response = registrationService.validate("vishal", "12345");


    }
    private Registration mockRegistration() {
        Registration registration = new Registration();
        registration.setUsername("vishal");
        registration.setPassword("12345");
        return registration;
    }
    @Test
    public void testvehicle()
    {
        when(registrationRepository.save(mockRegister())).thenReturn(mockRegister());
        Assert.assertEquals(mockRegister(),registrationService.vehicle(mockRegister()));

    }
    private Registration mockRegister() {
        Registration userRegister = new Registration();
        userRegister.setUsername("mayank");
        userRegister.setPassword("password");
        userRegister.setAddress("kota");
        userRegister.setDrivingLicenseNumber("rj20");
        userRegister.setVehicleNumber("1313");
        userRegister.setVehicleType("bus");
        userRegister.setVehicleCapacity(77);
        return userRegister;
    }
}
