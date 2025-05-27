package kr.or.ddit.dummy.case01.objs;

public class Foo {
	// ↓↓↓ 의존성을 주입받는 방법 설계
	private final Bar bar;	// 필수 의존 객체
	private Baz baz;	// 옵셔널 의존 객체
	
	// 생성자 주입방식(constructor injection), 필수 의존객체를 생성자를 통해 주입받는다.
	public Foo(Bar bar) {
		super();
		this.bar = bar;
	}
	
	// setter injection - 옵셔널 의존 객체는 세터를 통해서 주입한다.
	public void setBaz(Baz baz) {
		this.baz = baz;
	}
	
}
