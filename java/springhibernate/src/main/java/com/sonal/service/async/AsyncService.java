package com.sonal.service.async;

import java.util.concurrent.Future;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.sonal.components.IComponentLocator;
import com.sonal.persistence.bo.Employee;
import com.sonal.persistence.dao.IEmployeeDAO;

@Service
@EnableAsync
public class AsyncService implements IAsyncService {

	@Autowired
	private IComponentLocator componentLocator;

	@Async
	@Override
	@Transactional
	public Future<Boolean> saveEmployee(Employee employee) {
		boolean hasSavedSuccessfully = false;
		IEmployeeDAO employeeDAO = componentLocator.getDaoLocator().getEmployeeDAO();
		employeeDAO.saveEmployee(employee);
		hasSavedSuccessfully = true;
		Future<Boolean> hasSavedSuccessfullyFutureResponse = new AsyncResult<Boolean>(hasSavedSuccessfully);
		return hasSavedSuccessfullyFutureResponse;
	}

}
