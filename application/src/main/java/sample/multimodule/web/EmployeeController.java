package sample.multimodule.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sample.multimodule.domain.entity.Employee;
import sample.multimodule.json.entity.EmployeeReqResp;
import sample.multimodule.service.api.EmployeeService;
import sample.multimodule.webinterface.EmployeeControllerInterface;
/**
 * 
 * @author Aife Munshi
 *
 */
@RestController
@Validated
@RequestMapping("/v1")
public class EmployeeController implements EmployeeControllerInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@Override
	public @ResponseBody ResponseEntity<EmployeeReqResp> getEmployeeByEmployeeId(@PathVariable String employeeid) {
		EmployeeReqResp employeeEntity = null;
		try {
			Employee empl = employeeService.fetchAllUserById(employeeid);
			if (empl != null) {
				employeeEntity = new EmployeeReqResp(empl.getId(), empl.getFirstName(), empl.getLastName(), 
						empl.getMaidId(), String.valueOf(empl.getAge()), empl.getGender(), empl.getAddress() );
			}
			return new ResponseEntity<EmployeeReqResp>(employeeEntity, HttpStatus.OK);
		} catch (Exception excp) {
			LOGGER.error("Exception occured while fetching employee,Error message::::" + excp);
			return new ResponseEntity<EmployeeReqResp>(employeeEntity, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public @ResponseBody ResponseEntity<List<EmployeeReqResp>> getAllEmployees() {
		List<EmployeeReqResp> employeeList = new ArrayList<>();
		try {
			List<Employee> users = employeeService.fetchAllUsers();
			if (users != null && !users.isEmpty()) {
				users.forEach(elem -> {
					employeeList.add(new EmployeeReqResp(elem.getId(), elem.getFirstName(), elem.getLastName(), 
							elem.getMaidId(), String.valueOf(elem.getAge()), elem.getGender(), elem.getAddress()));
				});
			}

			return new ResponseEntity<List<EmployeeReqResp>>(employeeList, HttpStatus.OK);
		} catch (Exception excp) {
			LOGGER.error("Exception occured while fetching employee,Error message::::" + excp);
			return new ResponseEntity<List<EmployeeReqResp>>(employeeList, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public @ResponseBody ResponseEntity<Void> addEmployee(@Valid @RequestBody EmployeeReqResp request) {
		LOGGER.info("Inside addEmployee method:::");
		Employee employeeObject = null;

		if (request != null) {
			try {
				if (employeeService.fetchAllUserById(request.getEmpId()) != null) {
					LOGGER.warn("Employee already exists with id:::::" + request.getEmpId());
					return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} catch (Exception excp) {
				LOGGER.error("Exception occured while fetching employee from database,Error Message" + excp);
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			employeeObject = new Employee(request.getEmpId(), request.getFirstName(), request.getLastName(), 
					request.getMailId(),request.getGender(), Integer.parseInt(request.getAge()), request.getAddress());
		}

		try {
			employeeService.addUser(employeeObject);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception excp) {
			LOGGER.error("Exception occured while adding employee to database,Error Message" + excp);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public @ResponseBody ResponseEntity<Void> updateEmployee(@Valid @RequestBody EmployeeReqResp request) {
		LOGGER.info("Inside updateEmployee method:::");
		Employee userObject = null;

		if (request != null) {
			try {
				if (employeeService.fetchAllUserById(request.getEmpId()) == null) {
					LOGGER.warn("Nothing to update,UserId for employee:::::" + request.getEmpId());
					return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			} catch (Exception excp) {
				LOGGER.error("Exception occured while fetching employee from database,Error Message" + excp);
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			userObject = new Employee(request.getEmpId(), request.getFirstName(), request.getLastName(), 
					request.getMailId(),request.getGender(), Integer.parseInt(request.getAge()), request.getAddress());
		}
		try {
			employeeService.addUser(userObject);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception excp) {
			LOGGER.error("Exception occured while adding employee to database,Error Message" + excp);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeid) {
		LOGGER.info("Inside deleteEmployee method:::");
		try {
			employeeService.deleteUserById(employeeid);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception excp) {
			LOGGER.error("Exception occured while deleting employee from database,Error Message" + excp);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
