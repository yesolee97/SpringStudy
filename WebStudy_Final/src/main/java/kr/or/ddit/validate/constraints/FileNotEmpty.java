package kr.or.ddit.validate.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// 어노테이션이 마커!! 이거 검증해야돼 !!라고 표시하는 거 
// @Constraint에 구현체 넘겨서 어떻게 검증할건지 결정해줌
@Constraint(validatedBy = FileNotEmptyValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FileNotEmpty {
	 String message() default "파일이 비어있음";

	 Class<?>[] groups() default { };

	 Class<? extends Payload>[] payload() default { };
}
