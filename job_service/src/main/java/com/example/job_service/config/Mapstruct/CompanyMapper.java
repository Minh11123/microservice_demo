package com.example.job_service.config.Mapstruct;

import com.example.job_service.model.DTOresponse.CompanyDTO;
import com.example.job_service.model.entity.Company;
import org.mapstruct.Mapper;

@Mapper
public interface CompanyMapper extends BaseMapEntity<CompanyDTO, Company> {
}
