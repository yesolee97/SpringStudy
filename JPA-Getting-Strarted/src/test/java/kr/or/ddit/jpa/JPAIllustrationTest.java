package kr.or.ddit.jpa;

import static org.junit.jupiter.api.Assertions.fail;
import static java.time.LocalDateTime.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import kr.or.ddit.event.entity.Event;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JPAIllustrationTest {

	static EntityManagerFactory entityManagerFactory;


	@BeforeAll
	static void setUp() {
	    entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");   
	}
	
	
	@Order(1)
	@Test
	void testCreate() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	    EntityTransaction transaction = entityManager.getTransaction();
	    try {
	        transaction.begin();
	        entityManager.persist(new Event("Our very first event!", now()));   
	        entityManager.persist(new Event("A follow up event", now()));
	        transaction.commit();
	    }
	    catch (Exception e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	        throw e;
	    }
	    finally {
			entityManager.close();
		}
	}

	@Order(2)
	@Test
	void testReadAll() {
		try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
		    EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
			entityManager.createQuery("SELECT e FROM Event e", Event.class).getResultList()
				.forEach(event -> {
					System.out.println("Event (" + event.getDate() + ") : " + event.getTitle());
					event.setTitle("변경");
				});
	        transaction.commit();// 영속성 컨텍스트 개념 > 다 끝나고 나서 
		}
	}

}
