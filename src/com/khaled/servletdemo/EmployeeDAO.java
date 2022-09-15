package com.khaled.servletdemo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	private static List<Employee> employees = new ArrayList<Employee>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new Employee("khaled", "gamal", "SW Engineer"));
			add(new Employee("ahmed", "ibrahim", "DevOps Engineer"));
			add(new Employee("mohmed", "mahmod", "Site Engineer"));
			add(new Employee("hasan", "ezz", "Cloud Engineer"));
			add(new Employee("basem", "saad", "QC Engineer"));
			add(new Employee("husin", "ezzat", "QA Engineer"));
		}
	};

	public List<Employee> getEmployee() {
		return employees;
	}

	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employees.add(employee);
	}

	public Employee getEmployeeById(int employeeId) {
		Employee employee = null;
		for (Employee e : employees) {
			try {
				if (e.getId() == employeeId) {
					employee = e;
					break;
				}
			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}
		return employee;
	}

	public void updateEmployee(int id, String firstName, String lastName, String title) {
		// TODO Auto-generated method stub
		try {
			Employee emp = this.getEmployeeById(id);

			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setTitle(title);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public void deleteEmployee(int id) {

		Employee emp = this.getEmployeeById(id);
		employees.remove(employees.indexOf(emp));

	}

}
