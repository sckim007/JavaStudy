package ch06.array.multidimensional.sub5;

public class TestMain {

	public static void main(String[] args) {
		/** ��ü ���� */
		MemberVo member1 = new MemberVo();
		member1.setMemberNo("a001");
		member1.setMemberName("�輱ö");
		member1.setCellPhone("010-7221-9818");
		
		MemberVo member2 = new MemberVo();
		member2.setMemberNo("a002");
		member2.setMemberName("��̱�");
		member2.setCellPhone("010-3458-6236");
		
		MemberVo member3 = new MemberVo();
		member3.setMemberNo("a003");
		member3.setMemberName("������");
		member3.setCellPhone("010-5815-7237");

		MemberVo member4 = new MemberVo();
		member4.setMemberNo("a004");
		member4.setMemberName("�����");
		member4.setCellPhone("010-2490-7237");
		
		/** MemberVo �迭 ��ü���� */
		MemberVo[] members = {member1, member2, member3, member4};
		
		for (MemberVo m : members) {
			String info = m.getMemberNo();
			info += "\t" + m.getMemberName();
			info += "\t" + m.getCellPhone();

			System.out.println(info);
		}
	}
}
