package repo;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest // acts as a subset for loading application contextn in place of
				// @SpringBootConfiguration
//@ContextConfiguration(classes = { EmployeeConfig.class })
public class EmployeeRepositoryTest {

	@Resource
	private EmployeeRepository employeeRepository;

	@Test
	public void givenStudent_whenSave_thenGetOk() {
		Employee student = new Employee(1, "abc");
		employeeRepository.save(student);

		Employee student1 = new Employee(1, "abc");
		employeeRepository.save(student1);

		Employee student2 = employeeRepository.findByName("abc");
		assertEquals("abc", student2.getName());
	}
}