package com.example.job_service.config.Mapstruct;

import com.example.job_service.model.DTOresponse.JobDTO;
import com.example.job_service.model.entity.Job;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {})
public interface JobMapper extends BaseMapEntity<JobDTO,Job>{
}
