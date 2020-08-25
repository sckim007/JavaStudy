package ch08.method.recursive.main1;

import java.io.File;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * ������ �ƴ� ������ �ܿ� �ش� ���� ������ ����Լ��� ȣ���Ͽ� ���
 */

public class TestMain3 {

	/** ������ ������ �޾ƿ� ���� ���� �� ������ ����� ��ȸ */
	public static void scan(File file) {
		/** File ��ü�� null �Ǵ� �������� �ʴ� ���� ������ �� ���� */
		if (file == null || file.exists() == false) { return; }
		
		/** ������ ��� �ٽ� �������� ��ȸ */
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					/** ������ ��� ������ ������ ��ȸ */
					scan(f);
				}
			}
		}
		/** ������ ��� ������ ������ ��ȸ */
		else {
			String isFile = (file.isFile() == true ? "����" : "����");
			String name = file.getName();
			String path = file.getPath();
			System.out.println(isFile + "\t" + name + "\t" + path);
		}
	}
	
	public static void main(String[] args) {
		/** �ش� ���� �� ���������� ������ �������� */
		String rootPath = "d://Music";
		
		/** File ��ü ���� */
		File file = new File(rootPath);
		
		/** scan() �Լ� ȣ�� */
		scan(file);
	}
}
