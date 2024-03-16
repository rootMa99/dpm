package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "productivity")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Productivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DOUBLE")
    private Double real;

    @Column(columnDefinition = "DOUBLE")
    private Double target;
/*    @OneToOne(mappedBy = "productivity")
    private DateData dateData;*/
}
