package com.easydoers.employeeservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreTodos;

@Repository
public interface StoreTodosRepository extends JpaRepository<StoreTodos, Long>{

	StoreTodos findByStore(Store store);

	StoreTodos findByStoreAndTodo(Store store, String todo);

	List<StoreTodos> findByStoreAndTodosDate(Store store, LocalDate todosDate);

}
