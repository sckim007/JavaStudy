package ch08.method.recursive.main1;

import java.io.File;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 폴더가 아닌 파일의 겨우 해당 파일 정보를 재귀함수를 호출하여 출력
 */

public class TestMain3 {

	/** 파일의 정보를 받아와 하위 폴더 및 파일의 목록을 조회 */
	public static void scan(File file) {
		/** File 객체가 null 또는 존재하지 않는 파일 정보일 때 종료 */
		if (file == null || file.exists() == false) { return; }
		
		/** 폴더의 경우 다시 하위폴더 조회 */
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null) {
				for (File f : files) {
					/** 파일의 경우 파일의 정보를 조회 */
					scan(f);
				}
			}
		}
		/** 파일의 경우 파일의 정보를 조회 */
		else {
			String isFile = (file.isFile() == true ? "파일" : "폴더");
			String name = file.getName();
			String path = file.getPath();
			System.out.println(isFile + "\t" + name + "\t" + path);
		}
	}
	
	public static void main(String[] args) {
		/** 해당 폴더 및 하위폴더의 정보를 가져오기 */
		String rootPath = "d://Music";
		
		/** File 객체 생성 */
		File file = new File(rootPath);
		
		/** scan() 함수 호출 */
		scan(file);
	}
}
