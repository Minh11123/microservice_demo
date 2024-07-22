package com.example.job_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long jobId;

    @Column(nullable = true, unique = false)
    private String title;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private String location;
    @Column(nullable = true)
    private BigDecimal salary;
    @Column(nullable = true)
    private LocalDateTime postedDate;
    @Column(nullable = true)
    private LocalDateTime expirationDate;

    @Column(nullable = true)
    private LocalDateTime updatedDate;

    @Column(nullable = true)
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = true)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    private JobCategory category;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "job_skills",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<JobSkill> skills = new ArrayList<>();

    // Getters and Setters
}
