package kr.or.ddit.case07.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import kr.or.ddit.case07.objs.ResourcesVO;

@Configuration
public class Case07ResouceLoadingConfig {
	
	@Bean
	public ResourcesVO resVO(
			@Value("file:D:\\00.medias\\images\\cute4.JPG") Resource fR
			, @Value("classpath:kr/or/ddit/case05/conf/case05-Context.xml") Resource cR
			, @Value("https://commons.apache.org/proper/commons-io/dependency-info.html") Resource wR
			, @Value("텍스트값") String str
			, @Value("32") int number
	) {
		ResourcesVO resVO = new ResourcesVO(fR, str, number);
		resVO.setCR(cR);
		resVO.setWR(wR);
		return resVO;
	}
}
