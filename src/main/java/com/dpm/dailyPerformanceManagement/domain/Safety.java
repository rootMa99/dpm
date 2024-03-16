package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "safety")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Safety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double realValue;
    private double targetValue;
    @OneToOne(mappedBy = "safety")
    private DateData dateData;
}
