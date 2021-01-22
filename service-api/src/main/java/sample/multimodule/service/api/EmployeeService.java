package sample.multimodule.service.api;

import java.util.List;

import sample.multimodule.domain.entity.Employee;

/**
 * @author Aife Munshi
 *
 */
public interface EmployeeService {

	Employee fetchAllUserById(String userId) throws Exception;
	
	List<Employee> fetchAllUsers() throws Exception;

	String addUser(Employee userEntity) throws Exception;

	void deleteUserById(String userId) throws Exception;

}
