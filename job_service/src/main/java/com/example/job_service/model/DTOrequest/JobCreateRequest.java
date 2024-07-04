package com.example.job_service.model.DTOrequest;

import com.example.job_service.model.entity.Company;
import com.example.job_service.model.entity.JobCategory;
import com.example.job_service.model.entity.JobRequirement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCreateRequest{
    private String title;
    private String description;
    private String location;
    private BigDecimal salary;
    private LocalDateTime postedDate;
    private LocalDateTime expirationDate;
    private Long companyId;
    private Long jobCategoryId;
    private List<Long> requirementsId ;
    private List<Long> skillsId;
}
