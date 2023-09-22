package com.example.gtics_lab6_20200825.repository;

import com.example.gtics_lab6_20200825.entity.Location;
import com.example.gtics_lab6_20200825.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacionRepository extends JpaRepository<Location, Integer>  {
}
