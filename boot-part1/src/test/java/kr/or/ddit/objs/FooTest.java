package kr.or.ddit.objs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
class FooTest {
	@Autowired
	Foo foo;

	@Test
	void testMethod() {
		foo.method();
	}

}
