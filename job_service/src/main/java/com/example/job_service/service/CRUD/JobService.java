package com.example.job_service.service.CRUD;

import com.example.job_service.model.DTOrequest.JobCreateRequest;

import java.sql.SQLException;

public interface JobService {
    public void createJob(JobCreateRequest jobCreateRequest) throws SQLException;
    public void updateJob(JobCreateRequest jobCreateRequest);
    public void deleteJob(Long id);
}
