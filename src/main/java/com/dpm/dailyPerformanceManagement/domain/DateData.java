package com.dpm.dailyPerformanceManagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToMany(mappedBy = "dateData", cascade = CascadeType.ALL)
    @JsonIgnore
    private Delivery delivery;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    private Inventory inventory;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kaizen_id", referencedColumnName = "id")
    private Kaizen kaizen;
    @OneToMany(mappedBy = "dateData", cascade = CascadeType.ALL)
    @JsonIgnore
    private Productivity productivity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quality_id", referencedColumnName = "id")
    private Quality quality;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "safety_id", referencedColumnName = "id")
    private Safety safety;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skills_id", referencedColumnName = "id")
    private Skills skills;
}
