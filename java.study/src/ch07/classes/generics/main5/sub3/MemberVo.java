package ch07.classes.generics.main5.sub3;

public class MemberVo {
	/** �Ӽ� ���� */
	private String memberId;
	private String memberName;
	
	/** ������ �Լ� ���� */
	public MemberVo(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	/** �ڷ��� ������ ��ȯ�ϴ� �Լ� ���� */
	public Object[] getData() {
		return new Object[] {memberId, memberName};
	}
	
	/** ���̺� ��� ������ ��ȯ�ϴ� �Լ� ���� */
	public static String[] getHeaderInfo() {
		return new String[] {"ȸ�����̵�", "�̸�"};
	}
}
