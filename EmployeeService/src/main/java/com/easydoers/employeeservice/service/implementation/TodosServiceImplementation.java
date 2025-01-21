package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.dto.AssignTodosRequest;
import com.easydoers.employeeservice.dto.GetAssignedTodosForStoreResponse;
import com.easydoers.employeeservice.dto.TodoDTO;
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

		Map<String, Object> response = new HashMap<>();
		Store store = storeService.checkStore(assignTodosRequest.getDealerStoreId());
		for (String todo : assignTodosRequest.getTodos()) {
			StoreTodos storeTodos = new StoreTodos();
			storeTodos.setStore(store);
			storeTodos.setTodo(todo);
			storeTodos.setTodosDate(LocalDate.now());
			storeTodos.setCompleted(false);
			storeTodosRepository.save(storeTodos);
		}
		response.put("timestamp : ", LocalDateTime.now());
		response.put("message", "todos assigned for store " + store.getDealerStoreId() + " is successfully done");
		return response;
	}

	@Override
	public Map<String, Object> assignTodosCompletedByEmployee(
			TodosCompletedEmployeeRequest todosCompletedEmployeeRequest) {
		Map<String, Object> response = new HashMap<>();
		Store store = storeService.checkStore(todosCompletedEmployeeRequest.getDealerStoreId());
		for (String todo : todosCompletedEmployeeRequest.getTodos()) {
			StoreTodos storeTodos = new StoreTodos();
			Employee employee = employeeService.checkEmployee(todosCompletedEmployeeRequest.getEmployeeNtid());
			storeTodos = storeTodosRepository.findByStoreAndTodo(store, todo);
			storeTodos.setEmployee(employee);
			storeTodos.setCompleted(true);
			storeTodosRepository.save(storeTodos);
		}
		response.put("timestamp : ", LocalDateTime.now());
		response.put("message", "todos assigned for store " + store.getDealerStoreId() + " is successfully done by : "
				+ todosCompletedEmployeeRequest.getEmployeeNtid());
		return response;
	}

	@Override
	public GetAssignedTodosForStoreResponse getAssignTodosForStore(String dealerStoreId, LocalDate todosDate) {
		List<TodoDTO> todos = new ArrayList<>();
		TodoDTO todo = new TodoDTO();
		Store store = storeService.checkStore(dealerStoreId);
		List<StoreTodos> getStoreTodos = storeTodosRepository.findByStoreAndTodosDate(store, todosDate);
		for (StoreTodos storeTodos : getStoreTodos) {
			todo.setId(storeTodos.getId());
			todo.setTodoDescription(storeTodos.getTodo());
			todo.setCompleted(storeTodos.isCompleted());
			todos.add(todo);
		}

		return new GetAssignedTodosForStoreResponse(todos);

	}

}
