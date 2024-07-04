package com.example.job_service.config.Mapstruct;

public interface BaseMapEntity <D, T> {
    D toDto (T t);
}
