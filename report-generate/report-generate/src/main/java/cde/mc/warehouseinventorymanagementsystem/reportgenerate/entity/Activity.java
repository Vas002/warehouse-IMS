package cde.mc.warehouseinventorymanagementsystem.reportgenerate.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;



    @Entity
    @Data
    public class Activity {
        @Id
        private String Username;
        private String VehicleNumber;
        private String VehicleType;
        private String activity;
        private Integer capacity;


        public Activity(){}
        public Activity(String username, String vehicleNumber, String vehicleType, String activity, Integer capacity, LocalDate
                activityTimestamp) {
            Username = username;
            VehicleNumber = vehicleNumber;
            VehicleType = vehicleType;
            this.activity = activity;
            this.capacity = capacity;
            ActivityTimestamp = activityTimestamp;
        }
        @CreatedDate
        private LocalDate ActivityTimestamp;


    }


