package javaArithmetic;
/**
 * �ַ�ͳ��
 * ��������������һ���ַ���(������100����)��ͳ�����������ַ����ֵĴ�����
 * ��������
 * Ab100cd200
 * �������
 * 6
 * @author Administrator
 *
 */
public class CharStatistical {
	public static char[] putIn(String str){
		if(str.length()>0&&str.length()<=100){
			char[] ch = str.toCharArray();
			System.out.println("�ַ������ȣ�"+ch.length);
			/*char c = '1';
			System.err.println((int)c);*/
			for(int i=0;i<ch.length;i++){
				if(ch[i]>=49&&ch[i]<=57){
					System.out.println("���֣�"+ch[i]);
				}else{
					System.out.println("��ĸ��"+ch[i]);
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
