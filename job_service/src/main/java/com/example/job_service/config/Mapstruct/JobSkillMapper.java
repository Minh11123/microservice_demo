package com.example.job_service.config.Mapstruct;

import com.example.job_service.model.DTOresponse.JobSkillDTO;
import com.example.job_service.model.entity.JobSkill;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.mapstruct.Mapper;

@Mapper
public interface JobSkillMapper extends BaseMapEntity<JobSkillDTO, JobSkill> {
}
