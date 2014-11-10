package com.sonal.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonal.components.IResourceManager;
import com.sonal.persistence.bo.Employee;
import com.sonal.persistence.dao.IEmployeeDAO;
import com.sonal.service.async.IAsyncService;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IResourceManager componentLocator;

	@Override
	public List<Employee> getAllEmloyee() {

		List<Employee> employees = null;
		IEmployeeDAO employeeDAO = componentLocator.getDaoLocator().getEmployeeDAO();
		employees = employeeDAO.findAllEmployees();

		return employees;
	}
	
	@Override
	public void saveEmployeesInBulk(List<Employee> employees){
		Future<Boolean> saveEmployee = null;
		IAsyncService asyncService = componentLocator.getServiceLocator().getAsyncService();
		List<Future<Boolean>> futureResponses = new CopyOnWriteArrayList<Future<Boolean>>();
		for (Employee employee : employees) {
			saveEmployee = asyncService.saveEmployee(employee);
			futureResponses.add(saveEmployee);
		}
		
		for (Future<Boolean> curFutureResponse : futureResponses) {
			if(curFutureResponse.isDone()){
				futureResponses.remove(curFutureResponse);
			}
		}
	}
}
