package genericsAndArray;

import java.util.Arrays;

public class CopyingArrays {
	public static void main(String[] args) {
		int[] i = new int[7];
		int[] j = new int[10];
		//填充数组
		Arrays.fill(i, 1);
		Arrays.fill(j, 2);
		System.out.println("i= "+Arrays.toString(i));
		System.out.println("j= "+Arrays.toString(j));
		//复制数组arraycopy
		System.arraycopy(i, 0, j, 0, i.length);
		System.out.println("j= "+Arrays.toString(j));
		//数组比较equal
		System.out.println(Arrays.equals(i, j));
		System.out.println(Arrays.equals(i, i));
	}
}
