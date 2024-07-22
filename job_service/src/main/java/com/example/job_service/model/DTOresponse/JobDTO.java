package com.example.job_service.model.DTOresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {

    private String title;
    private String description;
    private String location;
    private BigDecimal salary;
    private String address;
    private String postedDate;
    private String expirationDate;
    private Long companyId;
    private Long categoryId;
    private String updatedDate;
}
