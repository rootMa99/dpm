package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "kaizen")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Kaizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DOUBLE")
    private Double real;

    @Column(columnDefinition = "DOUBLE")
    private Double target;
 /*   @OneToOne(mappedBy = "kaizen")
    private DateData dateData;*/
}
