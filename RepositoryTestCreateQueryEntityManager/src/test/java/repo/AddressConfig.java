
package repo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = { "model" })
@EnableJpaRepositories(basePackages = { "repo" })
public class AddressConfig {

	@Bean
	public SalesRepository createBean() {
		return new SalesRepository();
	}
	
}