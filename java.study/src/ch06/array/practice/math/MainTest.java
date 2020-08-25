package ch06.array.practice.math;

import java.util.Arrays;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10,12,13,11,15,16,14};
		float total = MyMath.total(array);
		float ave = MyMath.ave(array);
		float var = MyMath.variance(array);
		float stdev = MyMath.stdev(array);
		
		System.out.println("입력값\t: " + Arrays.toString(array));
		System.out.println("총점\t: " + total);
		System.out.println("평균\t: " + ave);
		System.out.println("분산\t: " + var);
		System.out.println("표준편차\t: " + stdev);
	}

}
