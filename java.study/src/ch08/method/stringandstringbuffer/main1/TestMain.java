package ch08.method.stringandstringbuffer.main1;

public class TestMain {

	public static void method(String str) {
		/** 파라미터의 문자열에 이어서 쓰기작업을 한다. */
		str += "-문자열 추가";
	}
	
	public static void method(StringBuffer sb) {
		/** StringBuffer 내부의 문자열에 이어서 쓰기 작업을 한다. */
		sb.append("-문자열 추가");
	}
	
	public static void main(String[] args) {
		/** String, String 변수의 생성 */
		String str = "메인 str";
		StringBuffer sb = new StringBuffer("메인 sb");
		System.out.println("String 초기 값="+str);
		System.out.println("StringBuffer 초기 값="+sb);
		
		/** static 함수사용 - 파라미터로 각각의 변수전달 */
		method(str);
		method(sb);
		
		/** String, StringBuffer 변수 값 조회 */
		System.out.println("String 변경 값="+str);
		System.out.println("StringBuffer 변경 값="+sb);
		
		/**
		 * String 초기 값=메인 str
		 * StringBuffer 초기 값=메인 sb
		 * String 변경 값=메인 str                   <-- 문자열을 변경할 수 없다.
		 * StringBuffer 변경 값=메인 sb-문자열 추가         <-- 문자열을 변경할 수 있다.
		 */
		
	}

}
