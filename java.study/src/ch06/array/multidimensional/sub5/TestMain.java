package ch06.array.multidimensional.sub5;

public class TestMain {

	public static void main(String[] args) {
		/** °´Ã¼ »ý¼º */
		MemberVo member1 = new MemberVo();
		member1.setMemberNo("a001");
		member1.setMemberName("±è¼±Ã¶");
		member1.setCellPhone("010-7221-9818");
		
		MemberVo member2 = new MemberVo();
		member2.setMemberNo("a002");
		member2.setMemberName("±è¹Ì±Õ");
		member2.setCellPhone("010-3458-6236");
		
		MemberVo member3 = new MemberVo();
		member3.setMemberNo("a003");
		member3.setMemberName("±èÇü¼ø");
		member3.setCellPhone("010-5815-7237");

		MemberVo member4 = new MemberVo();
		member4.setMemberNo("a004");
		member4.setMemberName("±è¹ü¼ö");
		member4.setCellPhone("010-2490-7237");
		
		/** MemberVo ¹è¿­ °´Ã¼»ý¼º */
		MemberVo[] members = {member1, member2, member3, member4};
		
		for (MemberVo m : members) {
			String info = m.getMemberNo();
			info += "\t" + m.getMemberName();
			info += "\t" + m.getCellPhone();

			System.out.println(info);
		}
	}
}
