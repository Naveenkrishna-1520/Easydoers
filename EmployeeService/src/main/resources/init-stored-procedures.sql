use employeeservice_db

DELIMITER $$

-- Drop existing procedures if they exist
DROP PROCEDURE IF EXISTS InsertAddressTestData$$
DROP PROCEDURE IF EXISTS InsertCompanyTestData$$
DROP PROCEDURE IF EXISTS InsertOwnerTestData$$
DROP PROCEDURE IF EXISTS InsertManagerTestData$$
DROP PROCEDURE IF EXISTS InsertStoreTestData$$
DROP PROCEDURE IF EXISTS InsertEmployeeTestData$$
DROP PROCEDURE IF EXISTS InsertEmployeeTargetTestData$$
DROP PROCEDURE IF EXISTS InsertStoreTargetTestData$$
DROP PROCEDURE IF EXISTS InsertPayCheckTestData$$
DROP PROCEDURE IF EXISTS InsertSaleTestData$$
DROP PROCEDURE IF EXISTS InsertWorkTestData$$

-- Stored Procedure for Address Table
CREATE PROCEDURE InsertAddressTestData()
BEGIN
    INSERT INTO address (street_name, city, state, zipcode)
    VALUES
        ('123 Main St', 'New York', 'NY', 10001),
        ('456 Elm St', 'San Francisco', 'CA', 94101),
        ('789 Pine St', 'Chicago', 'IL', 60601),
        ('321 Oak St', 'Austin', 'TX', 73301);
END$$

-- Stored Procedure for Company Table
CREATE PROCEDURE InsertCompanyTestData()
BEGIN
    INSERT INTO company (company_name, update_time, updated_person_name, address_id)
    VALUES
        ('Easydoers Pvt Ltd', NOW(), 'Admin1', 1),
        ('TechWave Solutions', NOW(), 'Admin2', 2);
END$$

-- Stored Procedure for Owner Table
CREATE PROCEDURE InsertOwnerTestData()
BEGIN
    INSERT INTO owner (owner_name, contact, update_time, updated_person_name, address_id, company_id)
    VALUES
        ('John Doe', 1234567890, NOW(), 'Admin1', 1, 1),
        ('Jane Smith', 9876543210, NOW(), 'Admin2', 2, 2);
END$$

-- Stored Procedure for Manager Table
CREATE PROCEDURE InsertManagerTestData()
BEGIN
    INSERT INTO manager (manager_ntid, manager_name, gender, contact, email, address_id, company_id)
    VALUES
        ('MGR001', 'Michael Scott', 'M', 1112223333, 'michael@dundermifflin.com', 1, 1),
        ('MGR002', 'Jan Levinson', 'F', 4445556666, 'jan@dundermifflin.com', 2, 2);
END$$

-- Stored Procedure for Store Table
CREATE PROCEDURE InsertStoreTestData()
BEGIN
    INSERT INTO store (store_name, dealer_store_id, store_contact_number, address_address_id, company_id)
    VALUES
        ('Downtown Store', 'DSTR001', 1231231234, 1, 1),
        ('Uptown Store', 'USTR002', 4564564567, 2, 2);
END$$

-- Stored Procedure for Employee Table
CREATE PROCEDURE InsertEmployeeTestData()
BEGIN
    INSERT INTO employee (employee_ntid, employee_name, phone_number, email, employee_pay_rate_per_hour, commission_percentage, address_id, company_id)
    VALUES
        ('EMP001', 'Jim Halpert', 7778889999, 'jim@dundermifflin.com', 25, 10, 1, 1),
        ('EMP002', 'Pam Beesly', 8889997777, 'pam@dundermifflin.com', 20, 8, 2, 2);
END$$

-- Stored Procedure for Employee Target Table
CREATE PROCEDURE InsertEmployeeTargetTestData()
BEGIN
    INSERT INTO employee_target (target_id, hsitarget, accessories_target_by_employee, phones_target_to_employee, smartwatch_traget_by_employee, tablets_target_by_employee, target_month, employee_id)
    VALUES
        (1, 100, 50.5, 30, 20, 10, '2025-01', 1),
        (2, 120, 60.5, 40, 30, 20, '2025-01', 2);
END$$

-- Stored Procedure for Store Target Table
CREATE PROCEDURE InsertStoreTargetTestData()
BEGIN
    INSERT INTO store_target (target_month, histarget_to_store, accessories_target_to_store, activation_target_to_store, smartwatch_target_to_store, tablets_target_to_store, store_id)
    VALUES
        ('2025-01', 200, 100.5, 80, 60, 40, 1),
        ('2025-01', 220, 120.5, 90, 70, 50, 2);
END$$

-- Stored Procedure for Pay Check Table
CREATE PROCEDURE InsertPayCheckTestData()
BEGIN
    INSERT INTO pay_check (accessories_commission, boxes_commission, total_earned_by_employee, employee_id)
    VALUES
        (50.5, 20.0, 300.0, 1),
        (60.5, 25.0, 350.0, 2);
END$$

-- Stored Procedure for Sale Table
CREATE PROCEDURE InsertSaleTestData()
BEGIN
    INSERT INTO sale (accessories, actual_card, actual_cash, boxes_sold, cash_expense, expense_reason, local_date, system_accessories, system_card, system_cash, tablets_sold, watches_sold, his_sold, employee_id, store_id)
    VALUES
        (200.0, 150.0, 50.0, 10, 20.0, 'Office Supplies', '2025-01-01', 210.0, 155.0, 55.0, 5, 3, 2, 1, 1),
        (250.0, 180.0, 70.0, 12, 25.0, 'Travel', '2025-01-02', 260.0, 185.0, 75.0, 6, 4, 3, 2, 2);
END$$

-- Stored Procedure for Work Table
CREATE PROCEDURE InsertWorkTestData()
BEGIN
    INSERT INTO work (clock_in_time, clock_out_time, date, number_of_hours_worked_by_employee, employee_id, store_id)
    VALUES
        ('09:00:00', '17:00:00', '2025-01-01', 8, 1, 1),
        ('10:00:00', '18:00:00', '2025-01-02', 8, 2, 2);
END$$

DELIMITER ;
