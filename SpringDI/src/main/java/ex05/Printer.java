package ex05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {
	
	/*
	 * @Autowired - 타입으로 빈을 주입 -> 없다면 이름으로 찾아서 자동으로 bean을 주입시켜준다.
	 * - 생성자, setter, 멤버변수에도 사용가능하다.
	 * 
	 * 만약 Autowired를 생성자가 아닌 멤버변수나 setter에 사용하는 경우 기본생성자가 없다면 에러가 난다.
	 * => setter나 멤버변수는 기본생성자가 필요하다.
	 * 
	 * @Resource - 이름으로 빈을 주입 -> 타입으로 찾아서 빈을 주입
	 * 
	 * @Qualifier - 빈의 이름을 강제 연결
	 * 컨테이너에 동일한 객체가 여러개있을 때 어느 객체를 주입할지
	 * 선택해주는 어노테이션
	 * 
	 */
	
//	짝꿍으로 사용하니까 알아두면 좋다. 많이 사용됨.
	@Autowired
	@Qualifier(value = "doc1")
	
	private Document doc;
	
	public Printer() {
		
	}
	
	//생성자
	//@Autowired
	public Printer(Document doc) {
		this.doc = doc;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
}
