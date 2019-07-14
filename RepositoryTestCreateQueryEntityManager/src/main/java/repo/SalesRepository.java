package repo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Employee;

@Repository
public class SalesRepository {

	@Autowired
	private EntityManager entityManager;

	  public Employee getFirstMerchantAddress(Integer streamlineId) {

	        return (Employee) entityManager.createQuery(
	                new StringBuilder("from  Employee emp where emp.id = :id ").toString()
	        ).setParameter("id", streamlineId).getSingleResult();
	    }
}