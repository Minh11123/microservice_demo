package com.example.job_service.config.Mapstruct;

import com.example.job_service.model.DTOresponse.JobCategoryDTO;
import com.example.job_service.model.entity.JobCategory;
import org.mapstruct.Mapper;

@Mapper
public interface JobCategoryMapper extends BaseMapEntity<JobCategoryDTO, JobCategory> {
}
