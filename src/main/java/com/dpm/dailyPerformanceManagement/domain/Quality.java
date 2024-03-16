package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "quality")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Quality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DOUBLE")
    private Double real;

    @Column(columnDefinition = "DOUBLE")
    private Double target;
   /* @OneToOne(mappedBy = "quality")
    private DateData dateData;*/
}
