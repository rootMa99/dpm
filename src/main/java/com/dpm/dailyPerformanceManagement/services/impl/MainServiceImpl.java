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
            dm.setNameData("inventory");
            dm.setTarget(dd.getInventory().getTargetValue());
            dm.setReal(dd.getInventory().getRealValue());
            dms.add(dm);
            dm.setNameData("kaizen");
            dm.setTarget(dd.getKaizen().getTargetValue());
            dm.setReal(dd.getKaizen().getRealValue());
            dms.add(dm);
            dm.setNameData("productivity");
            dm.setTarget(dd.getProductivity().getTargetValue());
            dm.setReal(dd.getProductivity().getRealValue());
            dms.add(dm);
            dm.setNameData("quality");
            dm.setTarget(dd.getQuality().getTargetValue());
            dm.setReal(dd.getQuality().getRealValue());
            dms.add(dm);
            dm.setNameData("safety");
            dm.setTarget(dd.getSafety().getTargetValue());
            dm.setReal(dd.getSafety().getRealValue());
            dms.add(dm);
            dm.setNameData("skills");
            dm.setTarget(dd.getSkills().getTargetValue());
            dm.setReal(dd.getSkills().getRealValue());
            dms.add(dm);
            sr.setDeliveryModels(dms);
            returnedData.add(sr);
        }
        return returnedData;
    }
}
