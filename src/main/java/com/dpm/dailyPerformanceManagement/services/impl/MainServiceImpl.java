package com.dpm.dailyPerformanceManagement.services.impl;

import com.dpm.dailyPerformanceManagement.domain.*;
import com.dpm.dailyPerformanceManagement.models.ActionPlanModel;
import com.dpm.dailyPerformanceManagement.models.DataRest;
import com.dpm.dailyPerformanceManagement.models.DeliveryModel;
import com.dpm.dailyPerformanceManagement.repositories.ActionPlanRepo;
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
    ActionPlanRepo actionPlanRepo;
    @Override
    public void addDeliveryData(DeliveryModel dm){
        DateData dd= dateDataRepo.findByDateDpm(dm.getDate());
        if (dd==null){
            DateData dd2= new DateData();
            dd2.setDateDpm(dm.getDate());
            Delivery d= new Delivery();
            d.setRealValue(dm.getReal());
            d.setTargetValue(dm.getTarget());
            if (dm.getApm()!=null){
                d.setActionPlan(getActionPlan(dm));
            }
            dd2.setDelivery(d);
            dateDataRepo.save(dd2);
        }else {
            Delivery d= new Delivery();
            d.setRealValue(dm.getReal());
            d.setTargetValue(dm.getTarget());
            if (dm.getApm()!=null){
                d.setActionPlan(getActionPlan(dm));
            }
            dd.setDelivery(d);
            dateDataRepo.save(dd);
        }
    }

    private ActionPlan getActionPlan(DeliveryModel dm) {
        ActionPlan ap=new ActionPlan();
        ap.setIssueDescription(dm.getApm().getIssueDescription());
        ap.setCauses(dm.getApm().getCauses());
        ap.setContermeasures(dm.getApm().getContermeasures());
        ap.setResp(dm.getApm().getResp());
        ap.setDueDate(dm.getApm().getDueDate());
        ap.setStatus(dm.getApm().getStatus());
        return actionPlanRepo.save(ap);
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
            if (dm.getApm()!=null){
                inventory.setActionPlan(getActionPlan(dm));
            }
            dd2.setInventory(inventory);
            dateDataRepo.save(dd2);
        }else {
            Inventory i= new Inventory();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
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
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
            dd2.setKaizen(i);
            dateDataRepo.save(dd2);
        }else {
            Kaizen i=new Kaizen();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
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
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
            dd2.setProductivity(i);
            dateDataRepo.save(dd2);
        }else {
            Productivity i=new Productivity();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
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
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
            dd2.setQuality(i);
            dateDataRepo.save(dd2);
        }else {
            Quality i=new Quality();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
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
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
            dd2.setSafety(i);
            dateDataRepo.save(dd2);
        }else {
            Safety i=new Safety();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
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
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
            dd2.setSkills(i);
            dateDataRepo.save(dd2);
        }else {
            Skills i=new Skills();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm()!=null){
                i.setActionPlan(getActionPlan(dm));
            }
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
            if (dd.getDelivery()!=null){
                Delivery dl=dd.getDelivery();
                dm.setTarget(dl.getTargetValue());
                dm.setReal(dl.getRealValue());
                if (dl.getActionPlan()!=null){
                    dm.setApm(getActionPlanModel(dl.getActionPlan()));
                }
            }
            dms.add(dm);
            DeliveryModel dm1=new DeliveryModel();
            dm1.setNameData("inventory");
            if (dd.getInventory()!=null){
                Inventory i=dd.getInventory();
                dm1.setTarget(i.getTargetValue());
                dm1.setReal(i.getRealValue());
                if (i.getActionPlan()!=null){
                    dm1.setApm(getActionPlanModel(i.getActionPlan()));
                }
            }
            dms.add(dm1);
            DeliveryModel dm2=new DeliveryModel();
            dm2.setNameData("kaizen");
            if (dd.getKaizen()!=null){
                dm2.setTarget(dd.getKaizen().getTargetValue());
                dm2.setReal(dd.getKaizen().getRealValue());
                if (dd.getKaizen().getActionPlan()!=null){
                    dm2.setApm(getActionPlanModel(dd.getKaizen().getActionPlan()));
                }
            }
            dms.add(dm2);
            DeliveryModel dm3=new DeliveryModel();
            dm3.setNameData("productivity");
            if (dd.getProductivity()!=null){
                dm3.setTarget(dd.getProductivity().getTargetValue());
                dm3.setReal(dd.getProductivity().getRealValue());
                if (dd.getProductivity().getActionPlan()!=null){
                    dm3.setApm(getActionPlanModel(dd.getProductivity().getActionPlan()));
                }
            }
            dms.add(dm3);
            DeliveryModel dm4=new DeliveryModel();
            dm4.setNameData("quality");
            if (dd.getQuality()!=null){
                dm4.setTarget(dd.getQuality().getTargetValue());
                dm4.setReal(dd.getQuality().getRealValue());
                if (dd.getQuality().getActionPlan()!=null){
                    dm4.setApm(getActionPlanModel(dd.getQuality().getActionPlan()));
                }
            }
            dms.add(dm4);
            DeliveryModel dm5=new DeliveryModel();
            dm5.setNameData("safety");
            if (dd.getSafety()!=null){
                dm5.setTarget(dd.getSafety().getTargetValue());
                dm5.setReal(dd.getSafety().getRealValue());
                if (dd.getSafety().getActionPlan()!=null){
                    dm5.setApm(getActionPlanModel(dd.getSafety().getActionPlan()));
                }
            }
            dms.add(dm5);
            DeliveryModel dm6=new DeliveryModel();
            dm6.setNameData("skills");
            if (dd.getSkills()!=null){
                dm6.setTarget(dd.getSkills().getTargetValue());
                dm6.setReal(dd.getSkills().getRealValue());
                if (dd.getSkills().getActionPlan()!=null){
                    dm6.setApm(getActionPlanModel(dd.getSkills().getActionPlan()));
                }
            }

            dms.add(dm6);
            sr.setDeliveryModels(dms);
            returnedData.add(sr);
        }
        return returnedData;
    }

    private static ActionPlanModel getActionPlanModel(ActionPlan actionPlan) {
        ActionPlanModel apm=new ActionPlanModel();
        apm.setCauses(actionPlan.getCauses());
        apm.setContermeasures(actionPlan.getContermeasures());
        apm.setDueDate(actionPlan.getDueDate());
        apm.setIssueDescription(actionPlan.getIssueDescription());
        apm.setResp(actionPlan.getResp());
        apm.setStatus(actionPlan.getStatus());
        return apm;
    }



}
