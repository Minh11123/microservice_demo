package com.example.job_service.model.DTOresponse;

import com.example.job_service.model.entity.Job;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class CompanyDTO {

    private String name;

    private String address;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs = new ArrayList<>();

}
