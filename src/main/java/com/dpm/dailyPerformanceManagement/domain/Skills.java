package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double realValue;
    private double targetValue;
    @OneToOne(mappedBy = "skills")
    private DateData dateData;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ap_id", referencedColumnName = "id")
    private ActionPlan actionPlan;
}
