package array;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InvertiSerie {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Integer x = null;
		do {
			try {
				x = input.nextInt();
				list.add(x);
			}catch(InputMismatchException e) {
				break;
			}
		}while(true);
		
		for(int i : zigzag(list.toArray())) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	private static int[] revert(int[] arr) {
		int[] arr2 = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			arr2[i] = arr[arr.length-i-1];
		}
		return arr2;
	}
	
	private static int[] revert(Object[] arr) {
		int[] arr2 = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			arr2[i] = (int)arr[arr.length-i-1];
		}
		
		return arr2;
	}
	
	private static int[] zigzag(Object[] arr) {
		int[] arr2 = new int [arr.length];
		
		for(int i = 0; i < arr.length/2; i++) {
			if(i != arr.length/2) {
				
				arr2[i*2] = (int)arr[i];
				arr2[i*2+1] = (int)arr[arr.length-2*i-1];
			}else {
				arr2[i] = (int)arr[arr.length-1];
			}
		}
		return arr2;
	}
	private static Object[] swap(Object[] arr, int from, int to) {
		Object sw = arr[to];
		arr[to] = arr[from];
		arr[from] = sw;
		return arr;
	}
}
