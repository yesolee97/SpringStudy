package kr.or.ddit.jpa;

import static java.time.LocalDateTime.now;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import kr.or.ddit.event.entity.Event;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)	// 이걸 붙여줘야 밑에 @Order 붙여준 거 실행됨
class HibernateIllustrationTest {
	static SessionFactory sessionFactory;

	@BeforeAll
	static void setUp() {
	    // A SessionFactory is set up once for an application!
	    final StandardServiceRegistry registry =
	            new StandardServiceRegistryBuilder()
	                    .build();     
	    try {
	        sessionFactory =
	                new MetadataSources(registry)             
	                        .addAnnotatedClass(Event.class)   
	                        .buildMetadata()                  
	                        .buildSessionFactory();           
	    }
	    catch (Exception e) {
	        // The registry would be destroyed by the SessionFactory, but we
	        // had trouble building the SessionFactory so destroy it manually.
	        StandardServiceRegistryBuilder.destroy(registry);
	    }
	}


	@Order(1)
	@Test
	void testCreate() {
		sessionFactory.inTransaction(session -> {   
			// persist(트랜젝셔널과 비슷한 의미) DB에 저장할거야 하는 의미!
		    session.persist(new Event("Our very first event!", now()));   
		    session.persist(new Event("A follow up event", now()));
		});
	}
	

	@Order(2)
	@Test
	void testReadAll() {
		sessionFactory.inTransaction(session -> {
		    session.createSelectionQuery("from Event", Event.class)   
	            .getResultList()   
	            .forEach(event -> {
	            	System.out.println("Event (" + event.getDate() + ") : " + event.getTitle());
	            	event.setTitle("제목 변경");
	            	session.flush();
	            });
		});
	}

}
