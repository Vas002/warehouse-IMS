package com.warehouse.vehicleserviceeureka;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    EurekaClient eurekaClient;

    @GetMapping("/vehicle-registration")
    public String Registration(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka= eurekaClient.getNextServerFromEureka("REGISTRATION_VEHICLE",false);
        String baseurl=nextServerFromEureka.getHomePageUrl();
       return restTemplate.getForObject(baseurl+"/registration/location",String.class);

    }

    @GetMapping("/vehicle-activity")
    public String Activity(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka= eurekaClient.getNextServerFromEureka("ACTIVITIES",false);
        String baseurl=nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(baseurl+"/details/location",String.class);

    }
    @GetMapping("/vehicle-report")
    public String Report(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        InstanceInfo nextServerFromEureka= eurekaClient.getNextServerFromEureka("REPORT-GENERATE",false);
        String baseurl=nextServerFromEureka.getHomePageUrl();
        return restTemplate.getForObject(baseurl+"/generate/location",String.class);

    }
}
