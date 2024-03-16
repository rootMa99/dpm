package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity(name = "date")
@Data
public class DateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery")
    private Delivery delivery;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory")
    private Inventory inventory;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kaizen")
    private Kaizen kaizen;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productivity")
    private Productivity productivity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quality")
    private Quality quality;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "safety")
    private Safety safety;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill")
    private Skills skills;
}
