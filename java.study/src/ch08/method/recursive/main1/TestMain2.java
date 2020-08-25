package ch08.method.recursive.main1;

import java.io.File;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 특정 디렉토리의 목록을 출력함.
 */

public class TestMain2 {

	public static void main(String[] args) {
		/** C 드라이브 경로 설정 */
		String path = "c://";
		
		/** File 객체 생성 */
		File file = new File(path);
		
		/** 해당 디렉토리의 하위에 있는 File 객체 목록을 조회 */
		File[] files = file.listFiles();
		
		if (files != null) {
			/** File 객체목록 상세내역 조회 */
			for (File f : files) {
				String name = f.getName();
				String isFile = (file.isFile() == true ? "파일" : "폴더");	
				System.out.println(isFile + "\t" + name);
			}
		}
	
	}

}
