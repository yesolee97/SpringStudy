package kr.or.ddit.dummy;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectionTest {
	public static void main(String[] args) throws Exception {
		Method mtd = ReflectionTest.class.getMethod("testMtd", String.class, Integer.class);
		Parameter[] params = mtd.getParameters();// 파라미터가 몇개일지 모르니까 s 붙음
		params[0].getName();
		log.info("첫번쨰 파라미터: {}", params[0].getName());
		log.info("두번쨰 파라미터: {}", params[1].getName());
	}
	// 시그니처만 리플렉션 해보려고 하는거
	public StringBuffer testMtd(String strArg, Integer intArg) {
		return null;
	}
	
}
