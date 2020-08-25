package ch08.method.stringandstringbuffer.main1;

public class TestMain {

	public static void method(String str) {
		/** �Ķ������ ���ڿ��� �̾ �����۾��� �Ѵ�. */
		str += "-���ڿ� �߰�";
	}
	
	public static void method(StringBuffer sb) {
		/** StringBuffer ������ ���ڿ��� �̾ ���� �۾��� �Ѵ�. */
		sb.append("-���ڿ� �߰�");
	}
	
	public static void main(String[] args) {
		/** String, String ������ ���� */
		String str = "���� str";
		StringBuffer sb = new StringBuffer("���� sb");
		System.out.println("String �ʱ� ��="+str);
		System.out.println("StringBuffer �ʱ� ��="+sb);
		
		/** static �Լ���� - �Ķ���ͷ� ������ �������� */
		method(str);
		method(sb);
		
		/** String, StringBuffer ���� �� ��ȸ */
		System.out.println("String ���� ��="+str);
		System.out.println("StringBuffer ���� ��="+sb);
		
		/**
		 * String �ʱ� ��=���� str
		 * StringBuffer �ʱ� ��=���� sb
		 * String ���� ��=���� str                   <-- ���ڿ��� ������ �� ����.
		 * StringBuffer ���� ��=���� sb-���ڿ� �߰�         <-- ���ڿ��� ������ �� �ִ�.
		 */
		
	}

}
