package com.base;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author taeheekim
 *
 */
public class S03_ComparatorTest {
	
   
   static class MyComparator implements Comparator<int[]>{ //arr은 2차원배열. 즉 arr의 원소는 1차원배열이란 뜻

		@Override
		public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1]; //배열의 두번째 인덱스로 비교할것인지
//            return o1[0] - o2[0]; //배열의 첫번째 인덱스로 비교할것인지는 알아서 해라 십새들아
		}
	   
   }
   
   public static void main(String[] args) {
      
      int[][] arr = new int[][]{{1,10},{3,50},{2,80},{4,10}};
      System.out.println("=========정렬 전=============");
      print(arr);
      Arrays.sort(arr, new MyComparator()); // arr은 클래스가 아니므로 나만의 Comparator 를 만들어야 한다! 
      System.out.println("=========정렬 후=============");
      print(arr);
   }
   
	private static void print(int[][] arr) {
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
}