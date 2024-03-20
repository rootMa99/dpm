package com.dpm.dailyPerformanceManagement.controller;


import com.dpm.dailyPerformanceManagement.domain.Files;
import com.dpm.dailyPerformanceManagement.models.DataRest;
import com.dpm.dailyPerformanceManagement.models.DeliveryModel;

import com.dpm.dailyPerformanceManagement.models.KpiRest;
import com.dpm.dailyPerformanceManagement.services.MainService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dpm")
@AllArgsConstructor
public class MainController {

    MainService mainService;

    @PostMapping(path = "/addDelivery")
    public void addDelivery(@RequestBody DeliveryModel deliveryModel) {
        mainService.addDeliveryData(deliveryModel);
    }

    @PostMapping(path = "/addInventory")
    public void addInventory(@RequestBody DeliveryModel deliveryModel) {
        mainService.addInventory(deliveryModel);
    }

    @PostMapping(path = "/addKaizen")
    public void addkaizen(@RequestBody DeliveryModel deliveryModel) {
        mainService.addKaizen(deliveryModel);
    }

    @PostMapping(path = "/addProductivity")
    public void addProductivity(@RequestBody DeliveryModel deliveryModel) {
        mainService.addProductivity(deliveryModel);
    }

    @PostMapping(path = "/addQuality")
    public void addQuality(@RequestBody DeliveryModel deliveryModel) {
        mainService.addQuality(deliveryModel);
    }

    @PostMapping(path = "/addSafety")
    public void addSafety(@RequestBody DeliveryModel deliveryModel) {
        mainService.addSafety(deliveryModel);
    }

    @PostMapping(path = "/addSkills")
    public void addSkills(@RequestBody DeliveryModel deliveryModel) {
        mainService.addSkills(deliveryModel);
    }

    @GetMapping(path = "/dataBetween")
    public List<DataRest> getDataBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                         @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate) {
        return mainService.getDataBetween(startDate, endDate);
    }

    @PostMapping("/kpio")
    public void addFileToProject(@RequestParam String kpiOwn, @RequestParam String name, @RequestParam String coName,
                                 @RequestParam(value = "file") MultipartFile file) throws IOException {
        //FileEntity fileEntity=fileService.addFileToProject(projectName, file);
        mainService.addKpiOwner(kpiOwn, name, coName, file);
    }

    @GetMapping("/downloadFile/{fileId:.+}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileId, HttpServletRequest request) throws FileNotFoundException {
        Files fileEntity = mainService.getFileByFileId(fileId);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileEntity.getFileType())).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFileName() + "\"").body(new ByteArrayResource(fileEntity.getData()));
    }
    @GetMapping("/owners")
    public List<KpiRest> getAllOwners(){
        return mainService.getAllKpiOwner();
    }

}
