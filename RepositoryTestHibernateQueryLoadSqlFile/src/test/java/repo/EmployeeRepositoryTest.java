package repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import model.Employee;

@RunWith(SpringRunner.class)
@EnableJpaRepositories("repo")
@EntityScan(basePackages = { "model" })
@EnableAutoConfiguration//loads context..and fills the repository
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	// @Sql("createUser.sql") // 1) sql file in the current package 2) if not then
	// in current package of test folder
	@Sql(scripts = { "classpath:sqls/createUser.sql" })
	public void whenInitializedByDbUnit_thenFindsByName() {
		Employee user = employeeRepository.findByName("abc");
		assertThat(user).isNotNull();
	}

}