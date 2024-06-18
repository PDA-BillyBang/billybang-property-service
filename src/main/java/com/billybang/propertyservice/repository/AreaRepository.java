package com.billybang.propertyservice.repository;

import com.billybang.propertyservice.model.statistic.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
    List<Area> findByDistrictId(Long districtId);
}
