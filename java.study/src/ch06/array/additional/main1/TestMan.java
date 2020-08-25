package ch06.array.additional.main1;

import java.util.Arrays;

public class TestMan {

	public static void main(String[] args) {
		/** 배열객체 생성하기 */
		int[] arr1 = new int[] {1,5,2,3,4};
		
		/** 배열복사하기 */
		int[] arr2 = new int[5];
		/** System.arraycopy(src, srcPos, dest, destPos, length); */
		System.arraycopy(arr1, 1, arr2, 0, 2);
				
		/** for 문을 이용하여 복사된 배열 조회 */
		System.out.println("----- 인덱스를 이용한 for 문 -----");
		for (int i=0;i<arr2.length;i++) {
			System.out.println(i + "th = " + arr2[i]);
		}
			
		/** 향상된 for 문을 이용하여 복사된 배열 조회 */
		System.out.println("----- 향상된 for 문 -----");
		int pos = 0;
		for (int a : arr2) {
			System.out.println(pos++ + "th =" + a);
		}
		
		/** Arrays.toString()을 이용하여 배열 조회 하기 */
		System.out.println("----- Arrays.toString -----");
		String toString = Arrays.toString(arr2);
		System.out.println (toString);
		
		/** Arrays.sort()을 이용하여 배열 정렬하기 */
		Arrays.sort(arr1);

		/** Arrays.toString을 이용하여 정렬된 배열 조회하기 */
		System.out.println("----- Arrays.toString after sort-----");
		String toString1 = Arrays.toString(arr1);
		System.out.println (toString1);
		
		/** 문자열 배열에 대한 sort 및 toString 확인 */
		String[] strArr = {"aaa","ccc", "bbb"};
		Arrays.sort(strArr);
		String toStrArr = Arrays.toString(strArr);
		System.out.println (toStrArr);
	}
}
