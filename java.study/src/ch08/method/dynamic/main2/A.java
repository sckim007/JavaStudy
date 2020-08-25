package ch08.method.dynamic.main2;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 재네릭스 방식의 객체를 입력받아 배열을 생성하여 반환하는 함수를 구현한 클래스
 */
public class A {
	
	/** 동적 반환 타입을 위한 제네릭스 사용 */
	public <T> T[] method(T... var) {
		
		T[] array = var;
		return array;
	}
}
