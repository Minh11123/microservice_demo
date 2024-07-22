package com.example.job_service.service.CRUD;

import com.example.job_service.model.DTOrequest.JobDtoRequest;
import com.example.job_service.model.DTOresponse.JobDTO;
import com.example.job_service.model.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

public interface JobService {

    Page<Job> getAllJobs(Pageable pageable);

    public JobDTO getJobByCondition(JobDtoRequest jobDtoRequest);
    public JobDTO createJob(JobDTO jobDTO) throws SQLException;
    public JobDTO updateJob(JobDTO jobDTO);
    public JobDTO deleteJob(Long id);
}
