package com.dpm.dailyPerformanceManagement.services;

import com.dpm.dailyPerformanceManagement.models.DeliveryModel;

public interface MainService {
    void addDeliveryData(DeliveryModel dm);

    void addInventory(DeliveryModel dm);

    void addKaizen(DeliveryModel dm);

    void addProductivity(DeliveryModel dm);

    void addQuality(DeliveryModel dm);

    void addSafety(DeliveryModel dm);

    void addSkills(DeliveryModel dm);
}
