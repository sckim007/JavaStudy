package ch08.method.recursive.main1;

import java.io.File;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * Ư�� ���丮�� ����� �����.
 */

public class TestMain2 {

	public static void main(String[] args) {
		/** C ����̺� ��� ���� */
		String path = "c://";
		
		/** File ��ü ���� */
		File file = new File(path);
		
		/** �ش� ���丮�� ������ �ִ� File ��ü ����� ��ȸ */
		File[] files = file.listFiles();
		
		if (files != null) {
			/** File ��ü��� �󼼳��� ��ȸ */
			for (File f : files) {
				String name = f.getName();
				String isFile = (file.isFile() == true ? "����" : "����");	
				System.out.println(isFile + "\t" + name);
			}
		}
	
	}

}
