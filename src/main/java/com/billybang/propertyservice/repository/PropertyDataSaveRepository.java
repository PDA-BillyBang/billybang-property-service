package com.billybang.propertyservice.repository;

import com.billybang.propertyservice.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDataSaveRepository extends JpaRepository<Property, Long> {
}
