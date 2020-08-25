package ch06.array.additional.main2;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {
		/** 복사할 대상 배열 */
		int[] array1 = new int[] {11,12,13,14,15};
		
		/** 복사될 대상 배열 */
		int[] array2 = new int[] {21,22,23,24,25};
		
		/** array1 배열의 인덱스 1부터 시작해서 array2 배열의 인덱스 0으로 길이 3만큼 복사 */
		System.arraycopy(array1, 1, array2, 0, 3);
		
		String toString = Arrays.toString(array2);
		System.out.println(toString);
	}
	
}
