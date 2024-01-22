package com.anp.project;


import javax.persistence.Column;// pre-defined package in java
import javax.persistence.Entity;// pre-defined package in java
import javax.persistence.GeneratedValue;// pre-defined package in java
import javax.persistence.GenerationType;// pre-defined package in java
import javax.persistence.Id;// pre-defined package in java
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;// pre-defined package in java
	
	
	// The @Entity annotation indicates that this class is a JPA entity and will be mapped to a database table.
	@Entity
	public class Employee {

	@Id 
	  // The @GeneratedValue annotation configures the way of incrementing the value of the annotated field.
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	// The @Column annotation is used to map the entity's field to the corresponding database column.
	 @Column(name = "empId")
	private int empId;
	private String empFirstName;
	private String empLastName;
	private String empGender;
	private String empEmail;
	private long mobileNumber;
	
	@ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;
	
	// Parameterized-Constructor
	public Employee(int empId, String empFirstName, String empLastName, 
	String empGender, String empEmail,
	long mobileNumber) {
	this.empId = empId;
	this.empFirstName = empFirstName;
	this.empLastName = empLastName;
	this.empGender = empGender;
	this.empEmail = empEmail;
	this.mobileNumber = mobileNumber;
	}
	// Zero-Argument-Constructor
	public Employee() {
	}
	
	// Getters and Setters
	// Getter method for Employee Id 
	public int getEmpId() {
	return empId;
	}
	// Setter method for Employee Id 
	public void setEmpId(int empId) {
	this.empId = empId;
	}
	// Getter method for Employee FirstName
	public String getEmpFirstName() {
	return empFirstName;
	}
	// Setter method for Employee FirstName
	public void setEmpFirstName(String empFirstName) {
	this.empFirstName = empFirstName;
	}
	// Getter method for Employee LastName
	public String getEmpLastName() {
	return empLastName;
	}
	// Setter method for Employee LastName
	public void setEmpLastName(String empLastName) {
	this.empLastName = empLastName;
	}
	// Getter method for Employee Gender
	public String getEmpGender() {
	return empGender;
	}
	// Setter method for Employee Gender
	public void setEmpGender(String empGender) {
	this.empGender = empGender;
	}
	// Getter method for Employee Email
	public String getEmpEmail() {
	return empEmail;
	}
	// Setter method for Employee Email
	public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
	}
	// Getter method for Employee MobileNumber
	public long getMobileNumber() {
	return mobileNumber;
	}
	// Setter method for Employee MobileNumber
	public void setMobileNumber(long mobileNumber) {
	this.mobileNumber = mobileNumber;
	}
	
	
	 public Department getDepartment() {
	        return department;
	    }

	    public void setDepartment(Department department) {
	        this.department = department;
	    }
	//To string method
		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
					+ ", empGender=" + empGender + ", empEmail=" + empEmail + ", mobileNumber=" + mobileNumber
					+ ", department=" + department + "]";
		}
		
	}


