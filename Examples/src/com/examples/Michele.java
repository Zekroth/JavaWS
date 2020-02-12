package com.examples;

public class Michele {
	public static boolean printIfDesc(int[] arr) {
		int i = 0;
		while(i<arr.length - 1) {
			if(arr[i] - arr[i+1] >= 0) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
}
