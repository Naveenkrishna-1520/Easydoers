package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.ToDos;

@Repository
public interface TodosRepository extends JpaRepository<ToDos, Long>{

}
