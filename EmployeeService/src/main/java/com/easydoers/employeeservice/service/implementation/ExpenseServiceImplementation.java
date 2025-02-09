package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.entity.Expense;
import com.easydoers.employeeservice.repository.ExpenseRepository;
import com.easydoers.employeeservice.service.ExpenseService;

@Service
public class ExpenseServiceImplementation implements ExpenseService{
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public Expense saveExpense(Expense expense) {
		expense = expenseRepository.save(expense);
		return expense;
	}

}
