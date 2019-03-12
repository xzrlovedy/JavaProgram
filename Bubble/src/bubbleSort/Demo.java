package bubbleSort;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		//整数类型排序
		int[] arr = {12,11,34,22,45};
		Utils.sort(arr);
		System.out.println(Arrays.toString(arr));
		//字符串排序
		String[] arr2 = {"aa","ab","aac","abc","de"};
		Utils.sort(arr2);
		System.out.println(Arrays.toString(arr2));
		//char类型
		char[] arr3 = {'b','a','f','j','d'};
		Utils.sort(arr3);
		System.out.println(Arrays.toString(arr3));
	}
}
