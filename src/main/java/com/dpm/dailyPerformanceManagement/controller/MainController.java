package com.dpm.dailyPerformanceManagement.controller;

import com.dpm.dailyPerformanceManagement.models.DeliveryModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dpm")
@AllArgsConstructor
public class MainController {



    public void addDelivery(@RequestBody DeliveryModel deliveryModel){

    }

}
