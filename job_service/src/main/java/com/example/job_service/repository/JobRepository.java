package com.example.job_service.repository;

import com.example.job_service.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> , Serializable {
}
