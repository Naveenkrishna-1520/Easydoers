package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
