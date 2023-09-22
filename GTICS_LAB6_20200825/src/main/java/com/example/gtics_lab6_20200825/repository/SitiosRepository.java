package com.example.gtics_lab6_20200825.repository;

import com.example.gtics_lab6_20200825.entity.Site;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface SitiosRepository  extends JpaRepository<Site, Integer> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO  site (SiteName, LocationID,InstallationDate, Latitude, Longitude\n" +
            "VALUES (?1,?2,?3,?4,?5);")
    void ingresodatos(String siteName, int locationID, String InstallationDate, String latitude, String longitude);
}
