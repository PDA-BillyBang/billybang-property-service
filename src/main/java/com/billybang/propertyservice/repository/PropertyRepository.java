package com.billybang.propertyservice.repository;

import com.billybang.propertyservice.model.property.Property;
import com.billybang.propertyservice.model.dto.response.PropertyResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    @Query("SELECT new com.billybang.propertyservice.model.dto.response.PropertyResponseDto(" +
            "COUNT(p), " +
            "MIN(p.price), " +
            "p.area1, p.latitude, p.longitude) " +
            "FROM Property p WHERE " +
            "p.realEstateType IN :realEstateTypes AND " +
            "p.tradeType IN :tradeTypes AND " +
            "p.price >= :priceMin AND " +
            "p.price <= :priceMax AND " +
            "p.longitude >= :leftLon AND " +
            "p.longitude <= :rightLon AND " +
            "p.latitude <= :topLat AND " +
            "p.latitude >= :bottomLat " +
            "GROUP BY p.longitude, p.latitude")
    List<PropertyResponseDto> findPropertyList(
            @Param("realEstateTypes") String[] realEstateType,
            @Param("tradeTypes") String[] tradeType,
            @Param("priceMin") int priceMin,
            @Param("priceMax") int priceMax,
            @Param("leftLon") double leftLon,
            @Param("rightLon") double rightLon,
            @Param("topLat") double topLat,
            @Param("bottomLat") double bottomLat
    );

    @Query("SELECT p FROM Property p WHERE " +
            "p.realEstateType IN :realEstateTypes AND " +
            "p.tradeType IN :tradeTypes AND " +
            "p.price >= :priceMin AND " +
            "p.price <= :priceMax AND " +
            "p.longitude = :longitude AND " +
            "p.latitude = :latitude")
    List<Property> findPropertyDetailList(
            @Param("realEstateTypes") String[] realEstateType,
            @Param("tradeTypes") String[] tradeType,
            @Param("priceMin") int priceMin,
            @Param("priceMax") int priceMax,
            @Param("latitude") double latitude,
            @Param("longitude") double longitude
    );
}
