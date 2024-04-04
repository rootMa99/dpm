package com.dpm.dailyPerformanceManagement.services.impl;

import com.dpm.dailyPerformanceManagement.domain.*;
import com.dpm.dailyPerformanceManagement.models.*;
import com.dpm.dailyPerformanceManagement.repositories.*;
import com.dpm.dailyPerformanceManagement.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MainServiceImpl implements MainService {
    Utils utils;
    KpiOwnerRepo kpiOwnerRepo;
    FilesRepo filesRepo;
    DateDataRepo dateDataRepo;
    DeliveryRepo deliveryRepo;
    ActionPlanRepo actionPlanRepo;
    ParetoRepo paretoRepo;

    @Override
    public void addDeliveryData(DeliveryModel dm) {
        DateData dd = dateDataRepo.findByDateDpm(dm.getDate());
        if (dd == null) {
            DateData dd2 = new DateData();
            dd2.setDateDpm(dm.getDate());
            List<Delivery> d = new ArrayList<>();
            Delivery dl= new Delivery();
            dl.setRealValue(dm.getReal());
            dl.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                dl.setActionPlan(getActionPlan(dm));
            }
            d.add(dl);
            dd2.setDelivery(d);
            dd = dateDataRepo.save(dd2);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        for (Delivery ds :dd.getDelivery() ){
                            p.setDelivery(ds);
                        }
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }

        } else {
            Delivery d = new Delivery();
            d.setRealValue(dm.getReal());
            d.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                d.setActionPlan(getActionPlan(dm));
            }
            List<Delivery> dlp= dd.getDelivery();
            dlp.add(d);
            dd.setDelivery(dlp);
            dd = dateDataRepo.save(dd);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        for (Delivery ds :dd.getDelivery() ){
                            p.setDelivery(ds);
                        }
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        }
    }


    private ActionPlan getActionPlan(DeliveryModel dm) {
        ActionPlan ap = new ActionPlan();
        ap.setIssueDescription(dm.getApm().getIssueDescription());
        ap.setCauses(dm.getApm().getCauses());
        ap.setContermeasures(dm.getApm().getContermeasures());
        ap.setResp(dm.getApm().getResp());
        ap.setDueDate(dm.getApm().getDueDate());
        ap.setStatus(dm.getApm().getStatus());
        return actionPlanRepo.save(ap);
    }

    @Override
    public void addInventory(DeliveryModel dm) {
        DateData dd = dateDataRepo.findByDateDpm(dm.getDate());
        if (dd == null) {
            DateData dd2 = new DateData();
            dd2.setDateDpm(dm.getDate());
            Inventory inventory = new Inventory();
            inventory.setRealValue(dm.getReal());
            inventory.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                inventory.setActionPlan(getActionPlan(dm));
            }

            dd2.setInventory(inventory);
            dd = dateDataRepo.save(dd2);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setInventory(dd.getInventory());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        } else {
            Inventory i = new Inventory();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }
            dd.setInventory(i);
            dd = dateDataRepo.save(dd);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setInventory(dd.getInventory());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        }
    }

    @Override
    public void addKaizen(DeliveryModel dm) {
        DateData dd = dateDataRepo.findByDateDpm(dm.getDate());
        if (dd == null) {
            DateData dd2 = new DateData();
            dd2.setDateDpm(dm.getDate());
            Kaizen i = new Kaizen();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }
            dd2.setKaizen(i);
            dd = dateDataRepo.save(dd2);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setKaizen(dd.getKaizen());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        } else {
            Kaizen i = new Kaizen();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }
            dd.setKaizen(i);
            dd = dateDataRepo.save(dd);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setKaizen(dd.getKaizen());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        }
    }

    @Override
    public void addProductivity(DeliveryModel dm) {
        DateData dd = dateDataRepo.findByDateDpm(dm.getDate());
        if (dd == null) {
            DateData dd2 = new DateData();
            dd2.setDateDpm(dm.getDate());
            Productivity i = new Productivity();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }
            List<Productivity> ps= new ArrayList<>();
            ps.add(i);
            dd2.setProductivity(ps);
            dd = dateDataRepo.save(dd2);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        for (Productivity pv:dd.getProductivity() ){
                            p.setProductivity(pv);
                        }
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        } else {
            Productivity i = new Productivity();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            i.setName(dm.getName());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }
            List<Productivity> pl= dd.getProductivity();
            pl.add(i);
            dd.setProductivity(pl);
            dd = dateDataRepo.save(dd);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        for (Productivity pvr:dd.getProductivity()){
                            p.setProductivity(pvr);
                        }

                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        }
    }

    @Override
    public void addQuality(DeliveryModel dm) {
        DateData dd = dateDataRepo.findByDateDpm(dm.getDate());
        if (dd == null) {
            DateData dd2 = new DateData();
            dd2.setDateDpm(dm.getDate());
            Quality i = new Quality();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }
            dd2.setQuality(i);
            dd = dateDataRepo.save(dd2);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setQuality(dd.getQuality());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        } else {
            Quality i = new Quality();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }

            dd.setQuality(i);
            dd = dateDataRepo.save(dd);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setQuality(dd.getQuality());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        }
    }

    @Override
    public void addSafety(DeliveryModel dm) {
        DateData dd = dateDataRepo.findByDateDpm(dm.getDate());
        if (dd == null) {
            DateData dd2 = new DateData();
            dd2.setDateDpm(dm.getDate());
            Safety i = new Safety();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }

            dd2.setSafety(i);
            dd = dateDataRepo.save(dd2);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setSafety(dd.getSafety());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }

        } else {
            Safety i = new Safety();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }

            dd.setSafety(i);
            dd = dateDataRepo.save(dd);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setSafety(dd.getSafety());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        }
    }

    @Override
    public void addSkills(DeliveryModel dm) {
        DateData dd = dateDataRepo.findByDateDpm(dm.getDate());
        if (dd == null) {
            DateData dd2 = new DateData();
            dd2.setDateDpm(dm.getDate());
            Skills i = new Skills();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }

            dd2.setSkills(i);
            dd = dateDataRepo.save(dd2);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setSkills(dd.getSkills());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        } else {
            Skills i = new Skills();
            i.setRealValue(dm.getReal());
            i.setTargetValue(dm.getTarget());
            if (dm.getApm() != null) {
                i.setActionPlan(getActionPlan(dm));
            }
            dd.setSkills(i);
            dd = dateDataRepo.save(dd);
            if (dm.getParetoModels() != null) {
                if (!dm.getParetoModels().isEmpty()) {
                    /* d.setParetos(getParetos(dm));*/
                    List<Pareto> paretoList = new ArrayList<>();
                    for (ParetoModel pm : dm.getParetoModels()) {
                        Pareto p = new Pareto();
                        p.setMotif(pm.getMotif());
                        p.setPercentage(pm.getPercentage());
                        p.setSkills(dd.getSkills());
                        paretoList.add(p);
                    }
                    paretoRepo.saveAll(paretoList);
                }
            }
        }
    }


    @Override
    public List<DataRest> getDataBetween(Date startDate, Date endDate) {
        List<DateData> dateData = dateDataRepo.findAllByDateDpmBetween(startDate, endDate);
        List<DataRest> returnedData = new ArrayList<>();
        for (DateData dd : dateData) {
            DataRest sr = new DataRest();
            sr.setDate(dd.getDateDpm());
            List<DeliveryModel> dms = new ArrayList<>();
            DeliveryModel dm = new DeliveryModel();
            dm.setNameData("delivery");
            if (dd.getDelivery() != null) {
                List<Delivery> dls = dd.getDelivery();
                for (Delivery dl: dls){
                    dm.setDate(dl.getDateData().getDateDpm());
                    dm.setTarget(dl.getTargetValue());
                    dm.setReal(dl.getRealValue());
                    if (dl.getActionPlan() != null) {
                        dm.setApm(getActionPlanModel(dl.getActionPlan()));
                    }
                    if (!dl.getParetos().isEmpty()) {
                        dm.setParetoModels(getParetoModels(dl.getParetos()));
                    }
                }

            }
            dms.add(dm);
            DeliveryModel dm1 = new DeliveryModel();
            dm1.setNameData("inventory");
            if (dd.getInventory() != null) {
                Inventory i = dd.getInventory();
                dm1.setDate(i.getDateData().getDateDpm());
                dm1.setTarget(i.getTargetValue());
                dm1.setReal(i.getRealValue());
                if (i.getActionPlan() != null) {
                    dm1.setApm(getActionPlanModel(i.getActionPlan()));
                }
                if (!i.getParetos().isEmpty()) {
                    dm1.setParetoModels(getParetoModels(i.getParetos()));
                }
            }
            dms.add(dm1);
            DeliveryModel dm2 = new DeliveryModel();
            dm2.setNameData("kaizen");
            if (dd.getKaizen() != null) {
                dm2.setDate(dd.getDateDpm());
                dm2.setTarget(dd.getKaizen().getTargetValue());
                dm2.setReal(dd.getKaizen().getRealValue());
                if (dd.getKaizen().getActionPlan() != null) {
                    dm2.setApm(getActionPlanModel(dd.getKaizen().getActionPlan()));
                }
                if (!dd.getKaizen().getParetos().isEmpty()) {
                    dm2.setParetoModels(getParetoModels(dd.getKaizen().getParetos()));
                }
            }
            dms.add(dm2);
            DeliveryModel dm3 = new DeliveryModel();
            dm3.setNameData("productivity");
            if (dd.getProductivity() != null) {
                dm3.setDate(dd.getDateDpm());
                dm3.setTarget(dd.getProductivity().getTargetValue());
                dm3.setReal(dd.getProductivity().getRealValue());
                if (dd.getProductivity().getActionPlan() != null) {
                    dm3.setApm(getActionPlanModel(dd.getProductivity().getActionPlan()));
                }
                if (!dd.getProductivity().getParetos().isEmpty()) {
                    dm3.setParetoModels(getParetoModels(dd.getProductivity().getParetos()));
                }
            }
            dms.add(dm3);
            DeliveryModel dm4 = new DeliveryModel();
            dm4.setNameData("quality");
            if (dd.getQuality() != null) {
                dm4.setDate(dd.getDateDpm());
                dm4.setTarget(dd.getQuality().getTargetValue());
                dm4.setReal(dd.getQuality().getRealValue());
                if (dd.getQuality().getActionPlan() != null) {
                    dm4.setApm(getActionPlanModel(dd.getQuality().getActionPlan()));
                }
                if (!dd.getQuality().getParetos().isEmpty()) {
                    dm4.setParetoModels(getParetoModels(dd.getQuality().getParetos()));
                }
            }
            dms.add(dm4);
            DeliveryModel dm5 = new DeliveryModel();
            dm5.setNameData("safety");
            if (dd.getSafety() != null) {
                dm5.setDate(dd.getDateDpm());
                dm5.setTarget(dd.getSafety().getTargetValue());
                dm5.setReal(dd.getSafety().getRealValue());
                if (dd.getSafety().getActionPlan() != null) {
                    dm5.setApm(getActionPlanModel(dd.getSafety().getActionPlan()));
                }
                if (!dd.getSafety().getParetos().isEmpty()) {
                    dm5.setParetoModels(getParetoModels(dd.getSafety().getParetos()));
                }
            }
            dms.add(dm5);
            DeliveryModel dm6 = new DeliveryModel();
            dm6.setNameData("skills");
            if (dd.getSkills() != null) {
                dm6.setDate(dd.getDateDpm());
                dm6.setTarget(dd.getSkills().getTargetValue());
                dm6.setReal(dd.getSkills().getRealValue());
                if (dd.getSkills().getActionPlan() != null) {
                    dm6.setApm(getActionPlanModel(dd.getSkills().getActionPlan()));
                }
                if (!dd.getSkills().getParetos().isEmpty()) {
                    dm6.setParetoModels(getParetoModels(dd.getSkills().getParetos()));
                }
            }
            dms.add(dm6);
            sr.setDeliveryModels(dms);
            returnedData.add(sr);
        }
        return returnedData;
    }

    private static List<ParetoModel> getParetoModels(List<Pareto> dl) {
        List<ParetoModel> pm = new ArrayList<>();
        for (Pareto p : dl) {
            ParetoModel pmm = new ParetoModel();
            pmm.setMotif(p.getMotif());
            pmm.setPercentage(p.getPercentage());
            pm.add(pmm);
        }
        return pm;
    }

    private static ActionPlanModel getActionPlanModel(ActionPlan actionPlan) {
        ActionPlanModel apm = new ActionPlanModel();
        apm.setCauses(actionPlan.getCauses());
        apm.setContermeasures(actionPlan.getContermeasures());
        apm.setDueDate(actionPlan.getDueDate());
        apm.setIssueDescription(actionPlan.getIssueDescription());
        apm.setResp(actionPlan.getResp());
        apm.setStatus(actionPlan.getStatus());
        return apm;
    }

    @Override
    public Files getFileByFileId(String fileId) throws FileNotFoundException {
        Files fe = filesRepo.findByFileId(fileId);
        if (fe == null) {
            throw new FileNotFoundException("File not found with id " + fileId);
        }
        return fe;
    }

    @Override
    public Files uploadFile(MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {

            if (fileName.contains("..")) {
                throw new IOException("File Name Contain A Invalid Path Sequence");
            }

            String fileId = utils.generateProjectId(22);
            String fileDownloadUri =
                    ServletUriComponentsBuilder.fromCurrentContextPath().path("/dpm").path("/downloadFile/").path(fileId).toUriString();

            return new Files(fileId, fileName, file.getContentType(), file.getBytes(),
                    fileDownloadUri);
        } catch (
                Exception e
        ) {
            throw new IOException("Could not store file " + fileName + ". Please try again!");
        }
    }

    @Override
    public void addKpiOwner(String kpiOwn, String name, String coName, MultipartFile file) throws IOException {
        Files filesf = filesRepo.findByFileId(kpiOwn);
        Files fileEntity = uploadFile(file);
        if (filesf == null) {
            String fileDownloadUri =
                    ServletUriComponentsBuilder.fromCurrentContextPath().path("/dpm").path("/downloadFile/").path(
                            kpiOwn).toUriString();
            fileEntity.setFileDownloadUri(fileDownloadUri);
            fileEntity.setFileName(name);
            fileEntity.setFileId(kpiOwn);
            KpiOwner kpiOwner = new KpiOwner();
            kpiOwner.setKpiOwn(kpiOwn);
            kpiOwner.setName(name);
            kpiOwner.setCoName(coName);
            kpiOwner = kpiOwnerRepo.save(kpiOwner);
            fileEntity.setKpiOwner(kpiOwner);
            filesRepo.save(fileEntity);
        } else {
            String fileDownloadUri =
                    ServletUriComponentsBuilder.fromCurrentContextPath().path("/dpm").path("/downloadFile/").path(
                            kpiOwn).toUriString();
            filesf.setFileDownloadUri(fileDownloadUri);
            filesf.setFileName(name);
            filesf.setFileId(kpiOwn);
            filesf.setData(fileEntity.getData());
            KpiOwner kpiOwner = new KpiOwner();
            kpiOwner.setId(filesf.getKpiOwner().getId());
            kpiOwner.setKpiOwn(kpiOwn);
            kpiOwner.setName(name);
            kpiOwner.setCoName(coName);
            kpiOwner = kpiOwnerRepo.save(kpiOwner);
            filesf.setKpiOwner(kpiOwner);
            filesRepo.save(filesf);
        }

    }

@Override
    public void editOwnerName(String kpiOwn ,String name, String cn){
        KpiOwner ko= kpiOwnerRepo.findByKpiOwn(kpiOwn);
        if (ko!=null){
            ko.setName(name);
            ko.setCoName(cn);
            kpiOwnerRepo.save(ko);
        }
    }


    @Override
    public List<KpiRest> getAllKpiOwner() {
        List<KpiOwner> kpiOwners = kpiOwnerRepo.findAll();
        List<KpiRest> kpiRests = new ArrayList<>();

        for (KpiOwner ko : kpiOwners) {
            KpiRest kr = new KpiRest();
            kr.setName(ko.getName());
            kr.setUri(ko.getFiles().getFileDownloadUri());
            kr.setKpiOwn(ko.getKpiOwn());
            kr.setCoName(ko.getCoName());
            kpiRests.add(kr);
        }

        return kpiRests;
    }
}
