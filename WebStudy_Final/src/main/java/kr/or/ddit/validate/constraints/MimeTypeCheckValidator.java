package kr.or.ddit.validate.constraints;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// ConstraintValidator 이 어노테이션을 어디에다 쓸건지 결정해준뎅 
public class MimeTypeCheckValidator implements ConstraintValidator<MimeTypeCheck, MultipartFile>{

	private String mainType;
	
	@Override
	public void initialize(MimeTypeCheck constraintAnnotation) {
		this.mainType = constraintAnnotation.mainType();
	}
	
	@Override
	public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
		if(value==null || value.isEmpty()) return true;	//null이거나 비어있으면 체크안하고 리턴
		String mime = value.getContentType();
		return mime!=null&mime.startsWith(mainType);
	}

}
