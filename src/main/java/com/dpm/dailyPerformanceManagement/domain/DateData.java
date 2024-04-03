package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity(name = "dateData")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date dateDpm;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id" , referencedColumnName = "id")
    private Delivery delivery;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kaizen_id", referencedColumnName = "id")
    private Kaizen kaizen;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productivity_id",referencedColumnName = "id")
    private Productivity productivity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quality_id", referencedColumnName = "id")
    private Quality quality;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "safety_id", referencedColumnName = "id")
    private Safety safety;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skills_id", referencedColumnName = "id")
    private Skills skills;
}
