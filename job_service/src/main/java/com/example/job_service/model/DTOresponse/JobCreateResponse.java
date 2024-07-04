package com.example.job_service.model.DTOresponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class JobCreateResponse {

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
