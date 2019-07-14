package repo;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("repo")
@EntityScan(basePackages = {"model"})
public class EmployeeConfig {
 
	@Bean
	public EmployeeRepository createEmployeeRepositoryBean() {
			return new EmployeeRepository();
	}
	
}