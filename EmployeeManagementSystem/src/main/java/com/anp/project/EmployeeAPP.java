package com.anp.project;

public class EmployeeAPP {
	public static void main(String[] args) {
		 EmployeeDAO employeeDAO = new EmployeeDAO();
		 DepartmentDAO departmentDAO = new DepartmentDAO();
		 
		  try {
		 // Create and save a department
	        Department itDepartment = new Department();
	        itDepartment.setDeptName("IT Department");
	        departmentDAO.saveDepartment(itDepartment);
		 // Create and save an employee
		 Employee newEmployee1 = new Employee(1, "John", "Doe", "Male", 
		"john.doe@example.com", 1234567890);
		 newEmployee1.setDepartment(itDepartment);
		 
		 Employee newEmployee2 = new Employee(2, "Alia", "Bhatt", 
		"Female", "alia.bhatt@example.com", 1234567891);
		 newEmployee2.setDepartment(itDepartment);
		 
		 Employee newEmployee3 = new Employee(3, "Varun", "Dhawan", 
		"Male", "varun.dhawan@example.com", 1234567892);
		 newEmployee3.setDepartment(itDepartment);
		 
		 employeeDAO.saveEmployee(newEmployee1,itDepartment);
		 employeeDAO.saveEmployee(newEmployee2,itDepartment);
		 employeeDAO.saveEmployee(newEmployee3,itDepartment);
		 // Fetch and display all employees
		 System.out.println("All Employees with Departments: ");
		 employeeDAO.getAllEmployees().forEach(employee -> {
	            System.out.println(employee);
	            System.out.println("Department: " + employee.getDepartment());
	        });
		
		 // Update an employee
		 Employee employeeToUpdate = employeeDAO.getEmployeeById(3);
		 if (employeeToUpdate != null) {
		 employeeToUpdate.setEmpFirstName("Rohan");
		 employeeDAO.updateEmployee(employeeToUpdate);
		 }
		 // Fetch and display all employees after update
		 System.out.println("All Employees after update: ");
		 employeeDAO.getAllEmployees().forEach(System.out::println);
		 // Delete an employee
		 employeeDAO.deleteEmployee(1);
		 // Fetch and display all employees after delete
		 System.out.println("All Employees after delete: ");
		 employeeDAO.getAllEmployees().forEach(System.out::println);
		 // Close EntityManagerFactory
		 employeeDAO.closeEntityManagerFactory();
		 } finally {
	            // Close EntityManagerFactory
	            employeeDAO.closeEntityManagerFactory();
	            departmentDAO.closeEntityManagerFactory();
	        }
	}
		}


