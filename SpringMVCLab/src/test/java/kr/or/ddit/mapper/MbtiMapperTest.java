package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.annotation.RootContextConfig;
import kr.or.ddit.conf.SpringRootContextConfig;
import kr.or.ddit.vo.MbtiVO;
import lombok.extern.slf4j.Slf4j;

//@SpringJUnitWebConfig(classes = SpringRootContextConfig.class)
@Slf4j
@RootContextConfig
class MbtiMapperTest {
	
	@Autowired
	MbtiMapper proxy;
	
	@Test
	void testInsertMbti() {
		MbtiVO vo = new MbtiVO("qdew");
		vo.setMtTitle("시발!");
		vo.setMtContent("시발시발!");
		log.info("{}", proxy.insertMbti(vo));
	}

	@Test
	void testSelectMbtiList() {
		log.info("{}", proxy.selectMbtiList());
	}

	@Test
	void testSelectMbti() {
		log.info("{}", proxy.selectMbti("ewew"));
	}

	@Test
	void testUpdateMbti() {
		MbtiVO vo = new MbtiVO("qdew");
		vo.setMtTitle("시발!");
		vo.setMtContent("무슨말인지 모르겠다!");
		log.info("{}", proxy.updateMbti(vo));
	}

	@Test
	void testDeleteMbti() {
		log.info("{}", proxy.deleteMbti("qdew"));
	}

}
