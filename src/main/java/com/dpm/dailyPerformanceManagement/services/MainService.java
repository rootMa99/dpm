package com.dpm.dailyPerformanceManagement.services;

import com.dpm.dailyPerformanceManagement.domain.Files;
import com.dpm.dailyPerformanceManagement.models.DataRest;
import com.dpm.dailyPerformanceManagement.models.DeliveryModel;
import com.dpm.dailyPerformanceManagement.models.KpiRest;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
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

    Files getFileByFileId(String fileId) throws FileNotFoundException;

    Files uploadFile(MultipartFile file) throws IOException;
    void addKpiOwner(String kpiOwn, String name, String coName, MultipartFile file) throws IOException;

    List<KpiRest> getAllKpiOwner();
}
