package com.example.job_service.Controller;

import com.example.job_service.model.DTOresponse.JobDTO;
import com.example.job_service.model.entity.Job;
import com.example.job_service.service.CRUD.JobService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("")
    public ResponseEntity<?> getAllJob(@PageableDefault Pageable pageable){
        Page<Job> page = jobService.getAllJobs(pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createJob(@RequestBody JobDTO jobDTO) throws SQLException {
        JobDTO job = jobService.createJob(jobDTO);
        return ResponseEntity.ok(job);
    }
}
