package sample.multimodule.mock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import sample.multimodule.domain.entity.Employee;
import sample.multimodule.service.api.EmployeeService;
/**
 * 
 * @author Aife Munshi
 *
 */
@Service
@Configuration
public class EmployeeServiceMockImpl implements EmployeeService {

	@Override
	public Employee fetchAllUserById(String userId) throws Exception {
		Employee mockUser = new Employee("1", "aife", "munshi", "a@gmail.com", "male", 32, "Kolkata");
		return mockUser;
	}

	@Override
	public List<Employee> fetchAllUsers() throws Exception {
		Employee mockUser1 = new Employee("1", "aife", "munshi", "a@gmail.com", "male", 32, "Kolkata");
		Employee mockUser2 = new Employee("1", "avik", "banerjee", "a@gmail.com", "male", 32, "Kolkata");
		List<Employee> mockUserList = new ArrayList<Employee>();
		mockUserList.add(mockUser1);
		mockUserList.add(mockUser2);
		return mockUserList;
	}

	@Override
	public String addUser(Employee userEntity) throws Exception {
		return "3";
	}

	@Override
	public void deleteUserById(String userId) throws Exception {
	}

}
