package kr.or.ddit.validate.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MimeTypeCheckValidator.class)// 한쌍으로 동작할 벨리데이씨팔 ~~
public @interface MimeTypeCheck {
	// 어노테이션 만들 때 필드에 default 주면 옵셔널 속성이래 없으면 필수 속성
	String mainType();
	
	String message() default "파일 MIME의 메인 타입 확인";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
