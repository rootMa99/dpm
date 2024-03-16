package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "safety")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Safety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DOUBLE")
    private Double real;

    @Column(columnDefinition = "DOUBLE")
    private Double target;
   /* @OneToOne(mappedBy = "safety")
    private DateData dateData;*/
}
