package ch07.classes.generics.main5.sub3;

public class MemberVo {
	/** 속성 정의 */
	private String memberId;
	private String memberName;
	
	/** 생성자 함수 정의 */
	public MemberVo(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	/** 자료의 정보를 반환하는 함수 정의 */
	public Object[] getData() {
		return new Object[] {memberId, memberName};
	}
	
	/** 테이블 헤더 정보를 반환하는 함수 정의 */
	public static String[] getHeaderInfo() {
		return new String[] {"회원아이디", "이름"};
	}
}
