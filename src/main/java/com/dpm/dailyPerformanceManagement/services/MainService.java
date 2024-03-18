package com.dpm.dailyPerformanceManagement.services;

import com.dpm.dailyPerformanceManagement.models.DataRest;
import com.dpm.dailyPerformanceManagement.models.DeliveryModel;

import java.util.Date;
import java.util.List;

public interface MainService {
    void addDeliveryData(DeliveryModel dm);

    void addInventory(DeliveryModel dm);

    void addKaizen(DeliveryModel dm);

    void addProductivity(DeliveryModel dm);

    void addQuality(DeliveryModel dm);

    void addSafety(DeliveryModel dm);

    void addSkills(DeliveryModel dm);

    List<DataRest> getDataBetween(Date startDate, Date endDate);
}
