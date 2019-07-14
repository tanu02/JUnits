# JUnits
## Junits for Different layers in a Web Application

## `POC on meaning of some annotations:`


**1. h2 is used as in memory database. Jpa for filling dependency**

@Datajpa annotation, will use the in memory db (configured in the class path in this case h2).

https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html

**2. Testing using Entity Manager:**

Data JPA tests we are injecting TestEntityManager bean.
@PersistanceContext

A persistence context is like a cache which contains a set of persistent entities. So once the transaction is finished, all persistent objects are detached from the EntityManager's persistence context and are no longer managed


**3. @JdbcTest VS @DataJpaTest**
@JdbcTest is similar to @DataJpaTest but it is used for tests that only require a DataSource and do not need Spring Data JDBC
If you prefer your test to run against a real database, you can use the @AutoConfigureTestDatabase annotation in the same way as for @DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE) will replace in memory db to actual db source.
