package com.easydoers.employeeservice.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.easydoers.employeeservice.dto.GetAssignedTodosForStoreResponse;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreTodos;

@Repository
public interface StoreTodosRepository extends JpaRepository<StoreTodos, Long>{

	StoreTodos findByStore(Store store);

	GetAssignedTodosForStoreResponse findByStoreAndTodosDate(Store store, LocalDate todosDate);

}
