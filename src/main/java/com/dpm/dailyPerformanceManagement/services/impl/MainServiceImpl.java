package com.dpm.dailyPerformanceManagement.services.impl;

import com.dpm.dailyPerformanceManagement.domain.*;
import com.dpm.dailyPerformanceManagement.models.DeliveryModel;
import com.dpm.dailyPerformanceManagement.repositories.DateDataRepo;
import com.dpm.dailyPerformanceManagement.repositories.DeliveryRepo;
import com.dpm.dailyPerformanceManagement.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MainServiceImpl implements MainService {
    DateDataRepo dateDataRepo;
    DeliveryRepo deliveryRepo;

    @Override
    public void addDeliveryData(DeliveryModel dm){
        DateData dd= dateDataRepo.findByDateDpm(dm.getDate());
        if (dd==null){
            DateData dd2= new DateData();
            dd2.setDateDpm(dm.getDate());
            Delivery d= new Delivery();
            d.setRealValue(dm.getReal());
            d.setTargetValue(dm.getTarget());
            dd2.setDelivery(d);
            dateDataRepo.save(dd2);
        }else {
            Delivery d= new Delivery();
            d.setRealValue(dm.getReal());
            d.setTargetValue(dm.getTarget());
            dd.setDelivery(d);
            dateDataRepo.save(dd);
        }
    }
    public void addInventory(DeliveryModel dm){
        DateData dd= dateDataRepo.findByDateDpm(dm.getDate());
        if (dd==null){
            DateData dd2= new DateData();
            dd2.setDateDpm(dm.getDate());
            Inventory inventory=new Inventory();
            inventory.setRealValue(dm.getReal());
            inventory.setTargetValue(dm.getTarget());
            dd2.setInventory(inventory);
            dateDataRepo.save(dd2);
        }else {
            Inventory i= new Inventory();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd.setInventory(i);
            dateDataRepo.save(dd);
        }
    }

    public void addKaizen(DeliveryModel dm){
        DateData dd= dateDataRepo.findByDateDpm(dm.getDate());
        if (dd==null){
            DateData dd2= new DateData();
            dd2.setDateDpm(dm.getDate());
            Kaizen i=new Kaizen();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd2.setKaizen(i);
            dateDataRepo.save(dd2);
        }else {
            Kaizen i=new Kaizen();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd.setKaizen(i);
            dateDataRepo.save(dd);
        }
    }
    public void addProductivity(DeliveryModel dm){
        DateData dd= dateDataRepo.findByDateDpm(dm.getDate());
        if (dd==null){
            DateData dd2= new DateData();
            dd2.setDateDpm(dm.getDate());
            Productivity i=new Productivity();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd2.setProductivity(i);
            dateDataRepo.save(dd2);
        }else {
            Productivity i=new Productivity();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd.setProductivity(i);
            dateDataRepo.save(dd);
        }
    }
}
