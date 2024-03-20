package com.dpm.dailyPerformanceManagement.repositories;

import com.dpm.dailyPerformanceManagement.domain.Pareto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParetoRepo extends JpaRepository<Pareto, Long> {
}
