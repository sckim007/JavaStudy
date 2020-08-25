package ch08.method.recursive.main1;

import java.io.File;

/** 요약
 * 
 * @author sckim007@gmail.com
 *
 * 특정 파일을 읽어 각종 정보를 조회함
 */

public class TestMain1 {

	public static void main(String[] args) {
		/** 물리파일 경로 설정 */
		String path = "c://tmp/test.txt";
		
		/** File 객체생성 */
		File file = new File(path);
		
		/** 해당 물리파일의 절대경로 조회 */
		String absolutePath = file.getAbsolutePath();
		System.out.println("absolutePath =" + absolutePath);
		
		/** 해당 물리파일의 파일명 조회 */
		String name = file.getName();
		System.out.println("name =" + name);
		
		/** 해당 물리파일의 존재여부를 조회 */
		boolean exists = file.exists();
		System.out.println("exists =" + exists);
		
		/** 해당 물리파일이 파일타입인지 조회 */
		boolean isFile = file.isFile();
		System.out.println("isFile =" + isFile);
		
		/** 해당 물리파일이 디렉토리타입인지 조회 */
		boolean isDir = file.isDirectory();
		System.out.println("isDir =" + isDir);
		
		/* 결과
           absolutePath =c:\tmp\test.txt
           name =test.txt
           exists =true
           isFile =true
           isDir =false
		 */

	}

}
