package ch08.method.recursive.main1;

import java.io.File;
import java.util.ArrayList;

/** ���
 * 
 * @author sckim007@gmail.com
 *
 * ������ �ƴ� ������ �ܿ� �ش� ���� ������ ArrayList�� ��´�.
 */

public class TestMain4 {
		
	/** ������ ������ �޾ƿ� ���� ���� �� ������ ����� ��ȸ */
	public static void scan(File file, ArrayList<File> fileList) {
		/** File ��ü�� null �Ǵ� �������� �ʴ� ���� ������ �� ���� */
		if (file == null || file.exists() == false) { return; }
		
		/** ������ ��� �ٽ� �������� ��ȸ */
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					/** ������ ��� ������ ������ ��ȸ */
					scan(f, fileList);
				}
			}
		}
		/** ������ ��� ������ ������ ��ȸ */
		else {
			String isFile = (file.isFile() == true ? "����" : "����");
			String name = file.getName();
			String path = file.getPath();
			//System.out.println(isFile + "\t" + name + "\t" + path);
			
			fileList.add(file);
		}
	}
	
	public static void main(String[] args) {
		/** �ش� ���� �� ���������� ������ �������� */
		String rootPath = "d://Music";
		
		/** File ��ü ���� */
		File file = new File(rootPath);
		
		/** �������� ������ �����ϱ� ���� ArrayList ��ü���� */
		ArrayList<File> list = new ArrayList<File>();
		
		/** scan() �Լ� ȣ�� */
		scan(file, list);
		
		/** ��ü��� ��ȸ */
		for (File f : list) {
			String isFile = (file.isFile() == true ? "����" : "����");
			String name = file.getName();
			String path = file.getPath();
			System.out.println(isFile + "\t" + name + "\t" + path);
 		}
		
	}

}
