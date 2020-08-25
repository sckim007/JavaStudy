package ch06.array.multidimensional.main2.sub3;

public class TestMain {

	public static void main(String[] args) {
		/** 2차원 배열 생성 */
		System.out.println("----- 2차원 : 1번째 방법 -----");
		/** 첫번째 방법 할당 */
		String[] arr1 = {"자료00", "자료01", "자료02"};
		String[] arr2 = {"자료10", "자료11", "자료12"};
		String[][] array1 = new String[][] {arr1, arr2};
		
		int[] arrInt = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int   total = 0;
		for (int i=0;i < arrInt.length ; i++) {
			total += arrInt[i];
		}
		System.out.println("총점  : " + total);	
		
		float ave = total/arrInt.length;
		System.out.println("평균  : " + ave);	
		
		double dev = 0;
		for (int val : arrInt) {
			dev += Math.pow((val - ave), 2);
		}
		System.out.println("분산  : " + dev);	
		
		double sdev = Math.sqrt(dev);
		System.out.println("편차  : " + sdev);	
				
		/** 인덱스를 이용한 for문으로 접근하기 */
		for (int i = 0;i<array1.length;i++) {
			for (int j = 0;j<array1[i].length;j++) {
				String data = array1[i][j];
				System.out.println("array1["+ i +"]["+ j +"] = " + data);
			}
		}
		
		/** 향상된 for문으로 접근하기 */
		for (String[] arr : array1) {
			for (String s : arr) {
				System.out.println("arr 자료접근 = " + s);
			}
		}
		
		/** 두번째 방법에 의한 할당 */
		System.out.println("----- 2차원 : 2번째 방법 -----");
		String[][] array2 = {arr1, arr2};
		/** 향상된 for문으로 접근하기 */
		for (String[] arr : array2) {
			for (String s : arr) {
				System.out.println("arr 자료접근 = " + s);
			}
		}
		/** 세번째 방법에 의한 할당 : 2차원 공간을 만든 후 나중에 값을 채우는 방법 */
		System.out.println("----- 2차원 : 3번째 방법 -----");
		String[][] array3 = new String[2][3];
		array3[0] = arr1;
		array3[1] = arr2;
		/** 향상된 for문으로 접근하기 */
		for (String[] arr : array3) {
			for (String s : arr) {
				System.out.println("arr 자료접근 = " + s);
			}
		}
	}
}
