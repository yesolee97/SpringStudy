package kr.or.ddit.validate;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Component
public class ErrorsUtils {
	
	public MultiValueMap<String, String> errorsToMap(BindingResult errors) {
		MultiValueMap<String, String> customErrors = new LinkedMultiValueMap<>();
		List<ObjectError> allErrors = errors.getAllErrors();
		for(ObjectError single : allErrors) {
			// 싱글이 프로퍼티 하나에 대한 검증결과를 가지고 있는건지 보는것임
			if(single instanceof FieldError) {
				FieldError fe = (FieldError) single;
				String key = fe.getField();
				String message = fe.getDefaultMessage();
				customErrors.add(key, message);
			}
		}
		
		return customErrors;
	}
}
