package day2;

import java.util.Arrays;

/*util类中有sort方法
 默认升序。
 要降序就在遍历的时候从后面遍历回前面。 */
public class SortDemo {
	public static void main(String[] args) {
		int[] vec = { 0, 15, -14, 45, 20, 70 };
		Arrays.sort(vec);

		System.out.println("升序排列：");
		for (int i = 0; i < vec.length; i++) {
			System.out.print(vec[i] + " ");
		}
		System.out.println("");
		System.out.println("降序排列：");
		for (int i = vec.length - 1; i >= 0; i--) {
			System.out.print(vec[i] + " ");
		}

	}
}