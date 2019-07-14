package repo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("repo")
@EntityScan(basePackages = { "model" })

public class EmployeeConfig {

}
