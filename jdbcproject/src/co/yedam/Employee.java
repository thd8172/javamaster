package co.yedam;

import java.sql.SQLException;
import java.util.Date;

public class Employee {
	private String empName;
	private String phone;
	private String email;
	private int salary;
	private String hireDate;
	private int empNo;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getHireDate() {
		return hireDate;

	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	@Override
	public String toString() {
		return String.format("%4d %8s %12s %5d\n", empNo, empName,email,salary);// + empNo  + " " + empName + "" + email + " " + salary;
	}
	
}
