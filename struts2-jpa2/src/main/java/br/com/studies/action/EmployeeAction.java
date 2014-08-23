package br.com.studies.action;

import java.util.List;

import br.com.studies.model.Employee;
import br.com.studies.persistence.GenericDAO;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;	
	
	private Employee employee;
	
	private List<Employee> employees;
	
	private GenericDAO<Employee> genericDao;	

	public EmployeeAction() {
		this.genericDao = new GenericDAO<Employee>();
	}
	
	public String addEmployeeData() {			
        return "addEmployeeData";
    }
	
	public String addEmployee(){
		genericDao.persist(employee);	
		return "addEmployee";
	}
	
	public String listEmployee(){
		employees = (List<Employee>)genericDao.findAll();		
		return "listEmployee";
	}

	public Employee getEmployee() {
		return employee;
	}	

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}
}