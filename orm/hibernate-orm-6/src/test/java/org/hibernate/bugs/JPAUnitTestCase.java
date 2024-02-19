package org.hibernate.bugs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.hibernate.entity.UserAuthorityEntity;
import org.hibernate.entity.UserEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		UserAuthorityEntity userAuthority = new UserAuthorityEntity();
		userAuthority.setAuthority("USER");

		UserEntity user = new UserEntity();
		user.setName("Luke Skywalker");
		user.setPassword("St@r+War$Rox!1");
		user.setEnabled(true);

		user.addUserAuthority(userAuthority);

		entityManager.persist(user);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
