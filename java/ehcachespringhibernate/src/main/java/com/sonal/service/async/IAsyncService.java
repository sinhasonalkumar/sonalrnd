package com.sonal.service.async;

import java.util.concurrent.Future;

import com.sonal.persistence.bo.Employee;

public interface IAsyncService {

	Future<Boolean> saveEmployee(Employee employee);

}
