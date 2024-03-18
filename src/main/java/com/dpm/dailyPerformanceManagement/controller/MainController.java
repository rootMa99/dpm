package com.dpm.dailyPerformanceManagement.controller;


import com.dpm.dailyPerformanceManagement.models.DataRest;
import com.dpm.dailyPerformanceManagement.models.DeliveryModel;

import com.dpm.dailyPerformanceManagement.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dpm")
@AllArgsConstructor
public class MainController {

    MainService mainService;

    @PostMapping(path = "/addDelivery")
    public void addDelivery(@RequestBody DeliveryModel deliveryModel){
        mainService.addDeliveryData(deliveryModel);
    }
    @PostMapping(path = "/addInventory")
    public void addInventory(@RequestBody DeliveryModel deliveryModel){
        mainService.addInventory(deliveryModel);
    }
    @PostMapping(path = "/addKaizen")
    public void addkaizen(@RequestBody DeliveryModel deliveryModel){
        mainService.addKaizen(deliveryModel);
    }
    @PostMapping(path = "/addProductivity")
    public void addProductivity(@RequestBody DeliveryModel deliveryModel){
        mainService.addProductivity(deliveryModel);
    }
    @PostMapping(path = "/addQuality")
    public void addQuality(@RequestBody DeliveryModel deliveryModel){
        mainService.addQuality(deliveryModel);
    }
    @PostMapping(path = "/addSafety")
    public void addSafety(@RequestBody DeliveryModel deliveryModel){
        mainService.addSafety(deliveryModel);
    }
    @PostMapping(path = "/addSkills")
    public void addSkills(@RequestBody DeliveryModel deliveryModel){
        mainService.addSkills(deliveryModel);
    }

    @GetMapping(path = "/dataBetween")
    public List<DataRest> getDataBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate){
        return null;
    }
}
