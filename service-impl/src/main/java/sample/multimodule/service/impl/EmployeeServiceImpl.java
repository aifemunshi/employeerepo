package sample.multimodule.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import sample.multimodule.domain.entity.Employee;
import sample.multimodule.repository.EmployeeRepository;
import sample.multimodule.service.api.EmployeeService;
/**
 * 
 * @author Aife Munshi
 *
 */
@Service
@Configuration
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository userRepo;
	
	@Override
	@Transactional
	public Employee fetchAllUserById(String userId) throws Exception {
		logger.info("fetchAllUserById started");
		return  userRepo.findById(userId);
	}
	 
	@Override
	@Transactional
	public String addUser(Employee userEntity) throws Exception{
		logger.info("addUser started");
		userRepo.save(userEntity);
		
		return userEntity.getId();
	}
	
	@Override
	@Transactional
	public void deleteUserById(String userId) throws Exception{
		logger.info("deleteUserById started");
		userRepo.delete(userId);
	}

	@Override
	@Transactional
	public List<Employee> fetchAllUsers() throws Exception {
		logger.info("fetchAllUsers started");
		return userRepo.findAll();
	}
	
}
