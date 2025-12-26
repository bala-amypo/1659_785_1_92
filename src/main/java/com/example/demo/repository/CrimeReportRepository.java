// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import java.util.List;
// import com.example.demo.model.CrimeReport;

// @Repository
// public interface CrimeReportRepository extends JpaRepository<CrimeReport,Long>{
//      // List<CrimeReport> findByLatLongRange(
//      //        double minLat, double maxLat,
//      //        double minLong, double maxLong);
// }


package com.example.demo.repository;

import com.example.demo.model.CrimeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {
    @Query("SELECT c FROM CrimeReport c WHERE c.latitude BETWEEN :minLat AND :maxLat AND c.longitude BETWEEN :minLong AND :maxLong")
    List<CrimeReport> findByLatLongRange(@Param("minLat") double minLat, @Param("maxLat") double maxLat, 
                                        @Param("minLong") double minLong, @Param("maxLong") double maxLong);
}