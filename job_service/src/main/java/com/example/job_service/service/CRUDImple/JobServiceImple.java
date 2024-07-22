package com.example.job_service.service.CRUDImple;

import com.example.job_service.config.Exception.AppException;
import com.example.job_service.config.Exception.ErrorResponseBase;
import com.example.job_service.config.Mapstruct.JobMapper;
import com.example.job_service.model.DTOrequest.JobDtoRequest;
import com.example.job_service.model.DTOresponse.JobDTO;
import com.example.job_service.model.entity.Company;
import com.example.job_service.model.entity.Job;
import com.example.job_service.model.entity.JobCategory;
import com.example.job_service.repository.CompanyRepository;
import com.example.job_service.repository.JobCategoryRepository;
import com.example.job_service.repository.JobRepository;
import com.example.job_service.service.CRUD.JobService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class JobServiceImple implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobCategoryRepository jobCategoryRepository;
    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public Page<Job> getAllJobs(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    @Override
    public JobDTO getJobByCondition(JobDtoRequest jobDtoRequest) {
        JobCategory jobCategory = new JobCategory();
        jobCategory.setCategoryId(Long.valueOf(jobDtoRequest.getJobCategory()));
        LocalDateTime updatedDate = LocalDateTime.parse(jobDtoRequest.getUpdatedDate());
        Optional<Job> job = jobRepository.findByCategoryAndUpdatedDateAndAddress(jobCategory, updatedDate,jobDtoRequest.getAddress());
        if(job.isPresent()){
            return jobMapper.toDto(job.get());
        }
        return null;
    }

    @Override
    public JobDTO createJob(JobDTO jobDTO) throws SQLException {
        Job job = jobMapper.toEntity(jobDTO);
        JobCategory jobCategory = jobCategoryRepository.findById(jobDTO.getCategoryId()).orElseThrow(
                () -> new AppException(ErrorResponseBase.NOT_FOUND_CATEGORY)
        );
        job.setCategory(jobCategory);
        Company company = companyRepository.findById(jobDTO.getCompanyId()).orElseThrow(
                () -> new AppException(ErrorResponseBase.NOT_FOUND_COMPANY));
        job.setCompany(company);
        Job job1 = jobRepository.save(job);
        return jobMapper.toDto(job1);
    }

    @Override
    public JobDTO updateJob(JobDTO jobDTO) {
        Job job = jobMapper.toEntity(jobDTO);
        Optional<Job> job1 = Optional.of(jobRepository.save(job));
        return jobMapper.toDto(job1.get());
    }

    @Override
    public JobDTO deleteJob(Long id) {
        jobRepository.deleteById(id);
        return jobMapper.toDto(jobRepository.findById(id).get());
    }
}
