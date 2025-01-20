package com.easydoers.employeeservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Work;


@Repository
public interface WorkRepository extends JpaRepository<Work, Long>{
	
	@Query("SELECT w FROM Work w WHERE w.employee.id = :employeeId AND DATE(w.date) = :date")
	Work findByEmployeeIdAndDate(@Param("employeeId") Long employeeId, @Param("date") LocalDate date);

	@Query("SELECT w FROM Work w WHERE w.employee.employeeId = :employeeId AND w.date BETWEEN :start AND :end")
	List<Work> findWorksByEmployeeIdAndDateRange(@Param("employeeId") Long employeeId,
	                                             @Param("start") LocalDate start,
	                                             @Param("end") LocalDate end);

}
