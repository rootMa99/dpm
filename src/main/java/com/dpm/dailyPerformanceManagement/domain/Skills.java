package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DOUBLE")
    private Double real;

    @Column(columnDefinition = "DOUBLE")
    private Double target;
 /*   @OneToOne(mappedBy = "skills")
    private DateData dateData;*/
}
