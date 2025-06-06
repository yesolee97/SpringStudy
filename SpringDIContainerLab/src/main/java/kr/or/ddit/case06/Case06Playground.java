package kr.or.ddit.case06;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.case06.conf.AdminConfig;
import kr.or.ddit.case06.conf.ParentConfig;
import kr.or.ddit.case06.conf.UserConfig;

public class Case06Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext parent = new AnnotationConfigApplicationContext(ParentConfig.class);
		ConfigurableApplicationContext admin = new AnnotationConfigApplicationContext(AdminConfig.class);
		admin.setParent(parent);
		ConfigurableApplicationContext user = new AnnotationConfigApplicationContext(UserConfig.class);
		user.setParent(parent);
		ConfigurableApplicationContext xml = new ClassPathXmlApplicationContext(
			new String[] {"kr/or/ddit/case06/conf/XmlChild-Context.xml"},
			parent
		);
	} 
}
