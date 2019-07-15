
package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Employee;
import service.DiscountService;

@RunWith(SpringRunner.class)
@WebMvcTest(DiscountController.class)

@ContextConfiguration(classes = { DiscountConfig.class })
public class DiscountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DiscountService service;

	@Test
	public void employeesListTest() throws Exception {
		List<Employee> listMock = mockList();

		when(service.findListByName(anyString())).thenReturn(listMock);

		MvcResult mvcResult = (MvcResult) this.mockMvc.perform(get("/findAll")).andDo(print())
				.andExpect(status().isOk()).andReturn();
		// .andExpect(status().is(HttpStatus.ACCEPTED.value())).andReturn();

		List<Employee> outputList = (List<Employee>) extractResponseList(mvcResult, Employee.class);
		assertThat(outputList.size() >= 1);
		assertThat(outputList.iterator().next().getName()).isNotNull();
		assertThat(outputList.iterator().next().getId()).isNotNull();
	}

	@Test
	public void employeeTest() throws Exception {
		Employee mock = mock();

		when(service.findByName(anyString())).thenReturn(mock);

		MvcResult mvcResult = (MvcResult) this.mockMvc.perform(get("/findOne")).andDo(print())
				.andExpect(status().isOk()).andReturn();
		// .andExpect(status().is(HttpStatus.ACCEPTED.value())).andReturn();

		Employee employee = (Employee) extractResponse(mvcResult, Employee.class);
		assertThat(employee.getName()).isNotNull();
		assertEquals(employee.getName(), "abc");
		assertEquals(employee.getId(), 1);
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello World")));
	}

	public List<Employee> mockList() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "abc"));
		return list;
	}

	public Employee mock() {
		Employee mock = new Employee(1, "abc");
		return mock;
	}

	private <T> T extractResponseList(MvcResult mvcResult, Class<T> clazz) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JavaType itemType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
		return mapper.readValue(mvcResult.getResponse().getContentAsString(), itemType);
	}

	private <T> T extractResponse(MvcResult mvcResult, Class<T> clazz) throws Exception {
		return new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), clazz);
	}
}