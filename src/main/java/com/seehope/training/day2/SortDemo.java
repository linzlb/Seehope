package com.seehope.training.day2;

import java.util.Arrays;

/**
 * Arrays.sort()
 */
public class SortDemo {
	public static void main(String[] args) {
		int[] vec = { 0, 15, -14, 45, 20, 70 };
		Arrays.sort(vec);
		for (int i = 0; i < vec.length; i++) {
			System.out.print(vec[i] + " ");
		}
		System.out.println("");
		for (int i = vec.length - 1; i >= 0; i--) {
			System.out.print(vec[i] + " ");
		}

	}
}