package repo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	EntityManager entityManager;

	public List<Employee> getEmployeeListBasedOnId(int id) {
		//createEntityManager();
		Query q = entityManager.createNativeQuery("select id, name from Employee_Table where id = :id");
		q.setParameter("id", id);
		List<Object[]> values = q.getResultList();
		return extractObject(values);
	}	

	public List<Employee> extractObject(List<Object[]> employees) {
		List<Employee> employeeList = new ArrayList<>();
		employees.forEach(obj -> {
			Employee emp = new Employee();
			//emp.setId(obj[0] != null ? ((BigInteger) obj[0]).intValue() : 0);
			emp.setName(obj[1] != null ? ((String) obj[1]) : "");
			employeeList.add(emp);

		});
		return employeeList;
	}

}