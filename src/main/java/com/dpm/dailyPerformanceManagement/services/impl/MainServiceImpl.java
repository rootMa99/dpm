package com.dpm.dailyPerformanceManagement.services.impl;

import com.dpm.dailyPerformanceManagement.domain.*;
import com.dpm.dailyPerformanceManagement.models.DataRest;
import com.dpm.dailyPerformanceManagement.models.DeliveryModel;
import com.dpm.dailyPerformanceManagement.repositories.DateDataRepo;
import com.dpm.dailyPerformanceManagement.repositories.DeliveryRepo;
import com.dpm.dailyPerformanceManagement.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public void addQuality(DeliveryModel dm){
        DateData dd= dateDataRepo.findByDateDpm(dm.getDate());
        if (dd==null){
            DateData dd2= new DateData();
            dd2.setDateDpm(dm.getDate());
            Quality i=new Quality();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd2.setQuality(i);
            dateDataRepo.save(dd2);
        }else {
            Quality i=new Quality();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd.setQuality(i);
            dateDataRepo.save(dd);
        }
    }
    @Override
    public void addSafety(DeliveryModel dm){
        DateData dd= dateDataRepo.findByDateDpm(dm.getDate());
        if (dd==null){
            DateData dd2= new DateData();
            dd2.setDateDpm(dm.getDate());
            Safety i=new Safety();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd2.setSafety(i);
            dateDataRepo.save(dd2);
        }else {
            Safety i=new Safety();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd.setSafety(i);
            dateDataRepo.save(dd);
        }
    }
    @Override
    public void addSkills(DeliveryModel dm){
        DateData dd= dateDataRepo.findByDateDpm(dm.getDate());
        if (dd==null){
            DateData dd2= new DateData();
            dd2.setDateDpm(dm.getDate());
            Skills i=new Skills();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd2.setSkills(i);
            dateDataRepo.save(dd2);
        }else {
            Skills i=new Skills();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            dd.setSkills(i);
            dateDataRepo.save(dd);
        }
    }

    @Override
    public List<DataRest> getDataBetween(Date startDate, Date endDate){
        List<DateData> dateData=dateDataRepo.findAllByDateDpmBetween(startDate, endDate);
        List<DataRest> returnedData= new ArrayList<>();
        for (DateData dd: dateData){
            DataRest sr= new DataRest();
            sr.setDate(dd.getDateDpm());
            List<DeliveryModel> dms=new ArrayList<>();
            DeliveryModel dm=new DeliveryModel();
            dm.setNameData("delivery");
            dm.setTarget(dd.getDelivery().getTargetValue());
            dm.setReal(dd.getDelivery().getRealValue());
            dms.add(dm);
            DeliveryModel dm1=new DeliveryModel();
            dm1.setNameData("inventory");
            dm1.setTarget(dd.getInventory().getTargetValue());
            dm1.setReal(dd.getInventory().getRealValue());
            dms.add(dm1);
            DeliveryModel dm2=new DeliveryModel();
            dm2.setNameData("kaizen");
            dm2.setTarget(dd.getKaizen().getTargetValue());
            dm2.setReal(dd.getKaizen().getRealValue());
            dms.add(dm2);
            DeliveryModel dm3=new DeliveryModel();
            dm3.setNameData("productivity");
            dm3.setTarget(dd.getProductivity().getTargetValue());
            dm3.setReal(dd.getProductivity().getRealValue());
            dms.add(dm3);
            DeliveryModel dm4=new DeliveryModel();
            dm4.setNameData("quality");
            dm4.setTarget(dd.getQuality().getTargetValue());
            dm4.setReal(dd.getQuality().getRealValue());
            dms.add(dm4);
            DeliveryModel dm5=new DeliveryModel();
            dm5.setNameData("safety");
            dm5.setTarget(dd.getSafety().getTargetValue());
            dm5.setReal(dd.getSafety().getRealValue());
            dms.add(dm5);
            DeliveryModel dm6=new DeliveryModel();
            dm6.setNameData("skills");
            dm6.setTarget(dd.getSkills().getTargetValue());
            dm6.setReal(dd.getSkills().getRealValue());
            dms.add(dm6);
            sr.setDeliveryModels(dms);
            returnedData.add(sr);
        }
        return returnedData;
    }
}
