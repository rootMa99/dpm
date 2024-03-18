package com.dpm.dailyPerformanceManagement.repositories;

import com.dpm.dailyPerformanceManagement.domain.DateData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DateDataRepo extends JpaRepository<DateData, Long> {
    DateData findByDateDpm(Date date);
    List<DateData> findAllByDateDpmBetween(Date startDate, Date endDate);
}
