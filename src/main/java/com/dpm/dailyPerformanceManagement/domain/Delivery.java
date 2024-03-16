package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "delivery")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DOUBLE")
    private Double real;

    @Column(columnDefinition = "DOUBLE")
    private Double target;
    /*@OneToOne(mappedBy = "delivery")
    private DateData date;*/
}
