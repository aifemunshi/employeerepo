package sample.multimodule.service.impl;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import sample.multimodule.domain.entity.Employee;
import sample.multimodule.mock.service.EmployeeServiceMockImpl;
import sample.multimodule.service.api.EmployeeService;

public class EmployeeServiceImplTest {

	@Test
	public void testFetchAllUserById() {
		EmployeeService employeeService = new EmployeeServiceMockImpl();
		// Positive case
		String testUserId1 = "1";
		Employee result = null;
		try {
			result = employeeService.fetchAllUserById(testUserId1);
			assertNotNull(result);
		} catch (Exception e) {
		}

	}

	@Test
	public void testFetchAllUsers() {
		// fail("Not yet implemented");
		EmployeeService employeeService = new EmployeeServiceMockImpl();
		// positive case
		List<Employee> resultList = null;
		try {
			resultList = employeeService.fetchAllUsers();
			assertNotNull(resultList);
		} catch (Exception e) {}
	}

}
