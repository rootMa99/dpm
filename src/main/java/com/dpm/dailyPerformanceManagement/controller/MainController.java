package com.dpm.dailyPerformanceManagement.controller;

import com.dpm.dailyPerformanceManagement.models.DeliveryModel;
import com.dpm.dailyPerformanceManagement.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

}
