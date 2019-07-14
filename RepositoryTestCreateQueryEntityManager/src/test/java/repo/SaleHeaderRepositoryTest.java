
package repo;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = AddressConfig.class)
public class SaleHeaderRepositoryTest {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	SalesRepository saleHeaderRepository;

	@Test
	public void test() {
		Employee mock = mock();
		entityManager.persist(mock);

		Employee empl = saleHeaderRepository.getFirstMerchantAddress(mock.getId());
		assertNotNull(empl);

	}

	public Employee mock() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("abc");
		return emp;
	}

}