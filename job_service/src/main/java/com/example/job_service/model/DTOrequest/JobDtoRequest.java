package com.example.job_service.model.DTOrequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDtoRequest {
    private String jobCategory;
    private String updatedDate;
    private String address;
}
