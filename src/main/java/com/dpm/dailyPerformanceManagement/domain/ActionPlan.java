package com.dpm.dailyPerformanceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity(name = "action_plan")
@Data
public class ActionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String issueDescription;
    private String causes;
    private String contermeasures;
    private String resp;
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    private String status;
    @OneToOne(mappedBy = "actionPlan")
    private Delivery delivery;
    @OneToOne(mappedBy = "actionPlan")
    private Inventory inventory;
    @OneToOne(mappedBy = "actionPlan")
    private Kaizen kaizen;
    @OneToOne(mappedBy = "actionPlan")
    private Productivity productivity;
    @OneToOne(mappedBy = "actionPlan")
    private Quality quality;
    @OneToOne(mappedBy = "actionPlan")
    private Safety safety;
    @OneToOne(mappedBy = "actionPlan")
    private Skills skills;
}
