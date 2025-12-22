package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CrimeReport;
@Repository
public interface CrimeReportRepository extends JpaRepository<CrimeReport,Long>{
    
}