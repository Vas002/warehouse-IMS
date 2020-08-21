package cde.mc.warehouseinventorymanagementsystem.reportgenerate.repository;

import cde.mc.warehouseinventorymanagementsystem.reportgenerate.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,String> {
    @Query(value = "select * from activity toa where toa.activity =?",nativeQuery = true)
    List<Activity>findByActivityType(String activity);

    @Query(value = "select * from activity toa where toa.capacity =? And MONTH(activity_timestamp)=?",nativeQuery = true)
    List<Activity>findByCapacityAndMonth(Integer capacity, Integer month);

    @Query(value = "select * from activity toa where toa.activity=? And Year(activity_timestamp)=?",nativeQuery = true)
    List<Activity>findByActivityTypeAndYear(String activity,Integer Year);
}
