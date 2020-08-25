package ch08.method.recursive.main1;

import java.io.File;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * Ư�� ������ �о� ���� ������ ��ȸ��
 */

public class TestMain1 {

	public static void main(String[] args) {
		/** �������� ��� ���� */
		String path = "c://tmp/test.txt";
		
		/** File ��ü���� */
		File file = new File(path);
		
		/** �ش� ���������� ������ ��ȸ */
		String absolutePath = file.getAbsolutePath();
		System.out.println("absolutePath =" + absolutePath);
		
		/** �ش� ���������� ���ϸ� ��ȸ */
		String name = file.getName();
		System.out.println("name =" + name);
		
		/** �ش� ���������� ���翩�θ� ��ȸ */
		boolean exists = file.exists();
		System.out.println("exists =" + exists);
		
		/** �ش� ���������� ����Ÿ������ ��ȸ */
		boolean isFile = file.isFile();
		System.out.println("isFile =" + isFile);
		
		/** �ش� ���������� ���丮Ÿ������ ��ȸ */
		boolean isDir = file.isDirectory();
		System.out.println("isDir =" + isDir);
		
		/* ���
           absolutePath =c:\tmp\test.txt
           name =test.txt
           exists =true
           isFile =true
           isDir =false
		 */

	}

}
