package regularExpression;

import java.util.Arrays;
/**
 * ���ַ�����������ʽƥ��ĵط��Ͽ�
 * @author Administrator
 *
 */
public class Splitting {
	public static String knights = "Once you have an object "+
			"representing a compiled regular expression, "+
			"what do you do with it?";
	public static void split(String regex) {
		System.out.println(Arrays.toString(knights.split(regex)));
	}
	public static void main(String[] args) {
		split(" ");
		split("\\W+");
		split("n\\W+");
		System.out.println(knights.replaceFirst("h\\w+", "don't have"));
		System.out.println(knights.replaceAll("do|you", "??"));
	}
}
