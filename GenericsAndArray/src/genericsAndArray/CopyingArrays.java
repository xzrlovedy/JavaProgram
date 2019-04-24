package genericsAndArray;

import java.util.Arrays;

public class CopyingArrays {
	public static void main(String[] args) {
		int[] i = new int[7];
		int[] j = new int[10];
		//�������
		Arrays.fill(i, 1);
		Arrays.fill(j, 2);
		System.out.println("i= "+Arrays.toString(i));
		System.out.println("j= "+Arrays.toString(j));
		//��������arraycopy
		System.arraycopy(i, 0, j, 0, i.length);
		System.out.println("j= "+Arrays.toString(j));
		//����Ƚ�equal
		System.out.println(Arrays.equals(i, j));
		System.out.println(Arrays.equals(i, i));
	}
}
