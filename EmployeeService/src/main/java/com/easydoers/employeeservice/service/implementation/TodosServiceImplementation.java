package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.dto.AssignTodosRequest;
import com.easydoers.employeeservice.dto.GetAssignedTodosForStoreResponse;
import com.easydoers.employeeservice.dto.TodosCompletedEmployeeRequest;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreTodos;
import com.easydoers.employeeservice.entity.ToDos;
import com.easydoers.employeeservice.repository.StoreTodosRepository;
import com.easydoers.employeeservice.repository.TodosRepository;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.TodosService;

@Service
public class TodosServiceImplementation implements TodosService {

	@Autowired
	private TodosRepository todosRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreTodosRepository storeTodosRepository;

	@Override
	public List<ToDos> getAllTodos() {
		List<ToDos> todos = todosRepository.findAll();
		return todos;
	}

	@Override
	public Map<String, Object> assignTodosToStore(AssignTodosRequest assignTodosRequest) {
		StoreTodos storeTodos = new StoreTodos();
		Map<String, Object> response = new HashMap<>();
		Store store = storeService.checkStore(assignTodosRequest.getDealerStoreId());
		storeTodos.setStore(store);
		storeTodos.setTodos(assignTodosRequest.getTodos());
		storeTodos.setTodosDate(LocalDate.now());
		storeTodosRepository.save(storeTodos);
		response.put("timestamp : ", LocalDateTime.now());
		response.put("message", "todos assigned for store " + store.getDealerStoreId() + " is successfully done");
		return response;
	}

	@Override
	public Map<String, Object> assignTodosCompletedByEmployee(
			TodosCompletedEmployeeRequest todosCompletedEmployeeRequest) {
		Map<String, Object> response = new HashMap<>();
		Store store = storeService.checkStore(todosCompletedEmployeeRequest.getDealerStoreId());
		StoreTodos storeTodos = new StoreTodos();
		Employee employee = employeeService.checkEmployee(todosCompletedEmployeeRequest.getEmployeeNtid());
		storeTodos = storeTodosRepository.findByStore(store);
		storeTodos.setEmployee(employee);
		storeTodosRepository.save(storeTodos);
		response.put("timestamp : ", LocalDateTime.now());
		response.put("message", "todos assigned for store " + store.getDealerStoreId() + " is successfully done by : "
				+ todosCompletedEmployeeRequest.getEmployeeNtid());
		return response;
	}

	@Override
	public GetAssignedTodosForStoreResponse getAssignTodosForStore(String dealerStoreId, LocalDate TodosDate) {
		Store store = storeService.checkStore(dealerStoreId);
		GetAssignedTodosForStoreResponse getTodos = storeTodosRepository.findByStoreAndTodosDate(store, TodosDate);
		return getTodos;
	}

}
