package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HealthInfo;

@Repository
public interface HealthInfoRepository extends CrudRepository<HealthInfo, Long>{
    
}
