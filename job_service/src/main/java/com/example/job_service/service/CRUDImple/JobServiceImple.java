package com.example.job_service.service.CRUDImple;

import com.example.job_service.model.DTOrequest.JobCreateRequest;
import com.example.job_service.model.entity.Job;
import com.example.job_service.repository.JobRepository;
import com.example.job_service.service.CRUD.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class JobServiceImple implements JobService {
    @Autowired
    private JobRepository jobRepository;


    @Override
    public void createJob(JobCreateRequest jobCreateRequest) throws SQLException {

    }

    @Override
    public void updateJob(JobCreateRequest jobCreateRequest) {

    }

    @Override
    public void deleteJob(Long id) {
//        Page<Optional<jobRepository>
    }
}
