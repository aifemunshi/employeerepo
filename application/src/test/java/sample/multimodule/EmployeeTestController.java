package sample.multimodule;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import sample.multimodule.domain.entity.Employee;
import sample.multimodule.service.api.EmployeeService;
import sample.multimodule.web.EmployeeController;

/**
 * 
 * @author Aife Munshi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
@WithMockUser
@Ignore
public class EmployeeTestController {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	Employee mockUser = new Employee("1", "aife", "munshi", "a@gmail.com", "male", 32, "Kolkata");

	String expectedUser = "{id:1, firstName:aife, lastName:munshi, mailId:a@gmail.com, gender:male, age:32, address:Kolkata}";

	@Test
	public void retrieveDetailsForUser() throws Exception {

		Mockito.when(employeeService.fetchAllUserById(Mockito.anyString())).thenReturn(mockUser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/employee").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(expectedUser, result.getResponse().getContentAsString(), false);
	}
}
