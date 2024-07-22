package com.example.job_service.repository;

import com.example.job_service.model.entity.Job;
import com.example.job_service.model.entity.JobCategory;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface JobRepository extends JpaRepository<Job,Long> , Serializable {
    Optional<Job> findByCategoryAndUpdatedDateAndAddress(JobCategory jobCategory, LocalDateTime updatedDate, String address);
}
