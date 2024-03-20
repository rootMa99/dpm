package com.dpm.dailyPerformanceManagement.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DeliveryModel {
    private Date date;
    private String nameData;
    private double real;
    private double target;
    private ActionPlanModel apm;
    private List<ParetoModel> paretoModels;
}
