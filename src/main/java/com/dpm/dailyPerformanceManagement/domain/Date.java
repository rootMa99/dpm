package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name = "date")
@Data
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

}
