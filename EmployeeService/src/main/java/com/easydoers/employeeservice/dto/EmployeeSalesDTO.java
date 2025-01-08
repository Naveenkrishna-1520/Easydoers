package com.easydoers.employeeservice.dto;

import java.util.List;

public class EmployeeSalesDTO {

    private String employeeNtid;
    private String employeeName;
    private List<SaleDTO> sales;

    // Constructor
    public EmployeeSalesDTO(String employeeNtid, String employeeName, List<SaleDTO> sales) {
        this.employeeNtid = employeeNtid;
        this.employeeName = employeeName;
        this.sales = sales;
    }

    // Getters
    public String getEmployeeNtid() {
        return employeeNtid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public List<SaleDTO> getSales() {
        return sales;
    }
}

