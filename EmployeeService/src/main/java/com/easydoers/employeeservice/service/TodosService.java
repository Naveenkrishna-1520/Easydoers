package com.easydoers.employeeservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import com.easydoers.employeeservice.dto.AssignTodosRequest;
import com.easydoers.employeeservice.dto.GetAssignedTodosForStoreResponse;
import com.easydoers.employeeservice.dto.TodosCompletedEmployeeRequest;
import com.easydoers.employeeservice.entity.ToDos;

public interface TodosService {

	List<ToDos> getAllTodos();

	Map<String, Object> assignTodosToStore(AssignTodosRequest assignTodosRequest);

	Map<String, Object> assignTodosCompletedByEmployee(TodosCompletedEmployeeRequest todosCompletedEmployeeRequest);

	GetAssignedTodosForStoreResponse getAssignTodosForStore(String dealerStoreId, LocalDate date);

}
