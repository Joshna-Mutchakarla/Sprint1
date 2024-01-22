package com.anp.project;
	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import javax.persistence.Query;
	import java.util.List;
	
	public class EmployeeDAO {
	 private final EntityManagerFactory emf;
		 public EmployeeDAO() {
			 this.emf = Persistence.createEntityManagerFactory("employee-jpa");  
			// Creating an EntityManagerFactory using the persistence unit named "employee-jpa"	 
	 }
	 public void saveEmployee(Employee employee, Department department ) {
		// Creating an EntityManager from the EntityManagerFactory
	 EntityManager em = emf.createEntityManager();
	// Starting a new transaction using EntityTransaction
	 EntityTransaction transaction = em.getTransaction();
	 try {
	 transaction.begin();  // Begin the transaction
	 if (employee.getEmpId() == 0) {
	 // If empId is 0, it's a new employee, persist it
	 em.persist(employee);
	 } else {
	 // If empId is not 0, it's an existing employee, merge it
	 em.merge(employee);
	 }
	 if (department != null) {
		 // If the department is provided, persist it
         em.persist(department);
         // Set the department for the employee
         employee.setDepartment(department);
     }
	 
	 transaction.commit(); // Committing the transaction
	 } catch (Exception e) {
	 if (transaction != null && transaction.isActive()) {
	 transaction.rollback();
	 }
	 e.printStackTrace();
	 } finally {
		// Closing the EntityManager  in a finally block to ensure resources are released
	 em.close();
	 }
	 }
	 
	 public Employee getEmployeeById(int empId) {
	 EntityManager em = emf.createEntityManager();
	 Employee employee = null;
	 try {
	 employee = em.find(Employee.class, empId);
	 if (employee != null) {
         employee.getDepartment(); // Fetch the associated department
     }
	 
	 } finally {
		// Closing the EntityManager in a finally block to ensure resources are released
	 em.close();
	 }
	 return employee;
	 }
	 public List<Employee> getAllEmployees() {
	 EntityManager em = emf.createEntityManager();
	 Query query = em.createQuery("FROM Employee");
	 return query.getResultList();
	 }
	 public void updateEmployee(Employee employee) {
	 EntityManager em = emf.createEntityManager();
	 EntityTransaction transaction = em.getTransaction();
	 try {
	 transaction.begin(); // Begin the transaction
	 em.merge(employee); // Use merge instead of persist for updates
	 transaction.commit();  // Committing the transaction
	 } catch (Exception e) {
	 if (transaction != null && transaction.isActive()) {
	 transaction.rollback();
	 }
	 e.printStackTrace();
	 } finally {
		// Closing the EntityManager in a finally block to ensure resources are released
	 em.close();
	 }
	 }
	 public void deleteEmployee(int empId) {
	 EntityManager em = emf.createEntityManager();
	 EntityTransaction tx = em.getTransaction();
	 try {
	 tx.begin(); // Begin the transaction
	 Employee employee = em.find(Employee.class, empId);
	 if (employee != null) {
	 em.remove(employee);
	 }
	 tx.commit();  // Committing the transaction
	 } catch (Exception e) {
	 if (tx.isActive()) {
	 tx.rollback();
	 }
	 e.printStackTrace();
	 } finally {
		// Closing the EntityManager and EntityManagerFactory in a finally block to ensure resources are released
	 em.close();
	 }
	 }
	 public void closeEntityManagerFactory() {
	 if (emf != null && emf.isOpen()) {
	 emf.close();
	 }
}
	}
	
