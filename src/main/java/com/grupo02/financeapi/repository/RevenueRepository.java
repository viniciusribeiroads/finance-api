package com.grupo02.financeapi.repository;

import com.grupo02.financeapi.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RevenueRepository extends JpaRepository<Revenue, Long> {

    List<Revenue> findByDescription(String description);

    @Query("select e from Revenue e where YEAR(e.date) = :year and MONTH(e.date) = :month")
    List<Revenue> findByYearAndMonth(Integer year, Integer month);
}
