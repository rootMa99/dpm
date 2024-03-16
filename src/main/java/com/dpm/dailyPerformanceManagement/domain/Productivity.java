package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "productivity")
@Data
public class Productivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double real;
    private Double target;
    @OneToOne()
    private DateData dateData;
}
