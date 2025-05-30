package kr.or.ddit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.conf.SpringRootContextConfig;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringJUnitWebConfig(classes = SpringRootContextConfig.class)
public @interface RootContextConfig {

}
