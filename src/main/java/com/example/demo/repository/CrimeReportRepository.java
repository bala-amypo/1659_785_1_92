package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.model.CrimeReport;

@Repository
public interface CrimeReportRepository extends JpaRepository<CrimeReport,Long>{
     List<CrimeReport> findByLatLongRange(
            double minLat, double maxLat,
            double minLong, double maxLong);
}