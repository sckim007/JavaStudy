package ch08.method.basicandreference;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 참조형으로 객체를 사용하는 경우 값을 변경할 수 있음
 */
public class TestMain2 {

	/** static method() 함수 정의 */
	public static void method(TypeA a) {
		/** a의 속성값을 증가 */
		a.setCount(a.getCount()+1);
	}
	
	public static void main(String[] args) {
		/** TypeA 객체 생성 */
		TypeA a =new TypeA();
		System.out.println("count=" + a.getCount());
		
		/** count를 파라미터 전달하여 함수 내부에서 값을 증가 */
		method(a);
		System.out.println("count=" + a.getCount());
		
		/** 결과
		 * count=0
		 * count=1
		 */
	}

}
