/**
 * 
 */
package sample.multimodule.webinterface;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sample.multimodule.json.entity.EmployeeReqResp;

/**
 * @author Aife Munshi
 *
 */

public interface EmployeeControllerInterface {

	@ApiOperation(value = "Rest get method to get employee by user id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Invalid Request Parameters") })
	@RequestMapping(value = "/employee/{employeeid}", method = RequestMethod.GET) 
	public @ResponseBody ResponseEntity<EmployeeReqResp> getEmployeeByEmployeeId(@PathVariable String employeeid);

	@ApiOperation(value = "Rest post method to add employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added employee"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Invalid Request Parameters") })
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Void> addEmployee(@RequestBody EmployeeReqResp request);

	@ApiOperation(value = "Rest post method to update user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated employee"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Invalid Request Parameters") })
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	ResponseEntity<Void> updateEmployee(EmployeeReqResp request);

	@ApiOperation(value = "Rest post method to delete employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted employee"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Invalid Request Parameters") })
	@RequestMapping(value = "/employee/{employeeid}", method = RequestMethod.DELETE)
	ResponseEntity<Void> deleteEmployee(@PathVariable String employeeid);

	@ApiOperation(value = "Rest post method to get all employees")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved employees"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	ResponseEntity<List<EmployeeReqResp>> getAllEmployees();

}
