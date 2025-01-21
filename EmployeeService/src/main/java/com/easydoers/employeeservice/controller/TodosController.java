package com.easydoers.employeeservice.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.AssignTodosRequest;
import com.easydoers.employeeservice.dto.GetAssignedTodosForStoreResponse;
import com.easydoers.employeeservice.dto.TodosCompletedEmployeeRequest;
import com.easydoers.employeeservice.entity.ToDos;
import com.easydoers.employeeservice.service.TodosService;

@RestController
@RequestMapping("v1/todos")
public class TodosController {

	@Autowired
	private TodosService todosService;

	@GetMapping("/getTodos")
	public ResponseEntity<List<ToDos>> getAllTodos() {
		List<ToDos> response = todosService.getAllTodos();
		return new ResponseEntity<List<ToDos>>(response, HttpStatus.OK);
	}

	@PostMapping("/assignTodosToStore")
	public ResponseEntity<Map<String, Object>> assignTodosToStore(@RequestBody AssignTodosRequest assignTodosRequest) {
		Map<String, Object> response = todosService.assignTodosToStore(assignTodosRequest);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/assignedTodosCompletedByEmployee")
	public ResponseEntity<Map<String, Object>> assignedTodosCompletedByEmployee(
			@RequestBody TodosCompletedEmployeeRequest todosCompletedEmployeeRequest) {
		Map<String, Object> response = todosService.assignTodosCompletedByEmployee(todosCompletedEmployeeRequest);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getAssinedTodos")
	public ResponseEntity<GetAssignedTodosForStoreResponse> getAssignTodosForStore(@RequestParam("dealerStoreId") String dealerStoreId){
		GetAssignedTodosForStoreResponse response = todosService.getAssignTodosForStore(dealerStoreId, LocalDate.now());
		return new ResponseEntity<GetAssignedTodosForStoreResponse>(response, HttpStatus.OK);
	}
}
