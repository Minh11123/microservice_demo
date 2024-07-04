package com.example.job_service.repository;

import com.example.job_service.model.entity.JobRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
@Repository
public interface JobRequirementRepository extends JpaRepository<JobRequirement, Long> {
}
