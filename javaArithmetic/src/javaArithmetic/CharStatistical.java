package javaArithmetic;
/**
 * 字符统计
 * 问题描述：输入一个字符串(长度在100以内)，统计其中数字字符出现的次数。
 * 样例输入
 * Ab100cd200
 * 样例输出
 * 6
 * @author Administrator
 *
 */
public class CharStatistical {
	public static char[] putIn(String str){
		if(str.length()>0&&str.length()<=100){
			char[] ch = str.toCharArray();
			System.out.println("字符串长度："+ch.length);
			/*char c = '1';
			System.err.println((int)c);*/
			for(int i=0;i<ch.length;i++){
				if(ch[i]>=49&&ch[i]<=57){
					System.out.println("数字："+ch[i]);
				}else{
					System.out.println("字母："+ch[i]);
				}
			}
			return ch;
		}
		return null;
	}
	public static void main(String[] args) {
		putIn("Ab100cd200");
	}
}
