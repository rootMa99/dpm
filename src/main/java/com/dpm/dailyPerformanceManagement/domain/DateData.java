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
    private Date date;
/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id" , referencedColumnName = "id")
    private Delivery delivery;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kaizen_id", referencedColumnName = "id")
    private Kaizen kaizen;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productivity_id",referencedColumnName = "id")
    private Productivity productivity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quality_id", referencedColumnName = "id")
    private Quality quality;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "safety_id", referencedColumnName = "id")
    private Safety safety;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skills_id", referencedColumnName = "id")
    private Skills skills;*/
}
