package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Kaizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double real;
    private Double target;
    @OneToOne(mappedBy = "productivity")
    private DateData dateData;
}
