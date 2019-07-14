package repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(
		  classes = { EmployeeConfig.class })

public class EmployeeRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void findEmployeesBydId() {
		// given
		Employee abc = new Employee(1, "abc");
		entityManager.persist(abc);
		entityManager.flush();

		List<Employee> employeesList = employeeRepository.getEmployeeListBasedOnId(1);

		assertNotNull(employeesList);
		employeesList.forEach(employee -> {
			assertThat(employee.getClass()).isNotNull();
			assertThat(employee.getName()).isEqualTo(abc.getName());
		});
		
	}

}