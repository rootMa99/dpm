package com.dpm.dailyPerformanceManagement.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DataRest {
    private Date date;
    List<DeliveryModel> productivity;
    List<DeliveryModel> deliveryModels;
}
