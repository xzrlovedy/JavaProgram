package javaArithmetic;
/**
 * �ݹ龭���㷨
 * @author Administrator
 *
 */
public class Recursion {
	/**
	 * 쳲��������У����ص�i��Ԫ�ص�ֵ
	 * @param i ��i��Ԫ��
	 * @return
	 */
	public static int f(int i){
		if(i==1||i==2){
			return 1;
		}else{
			return f(i-1)+f(i-2);
		}
	}
	/**
	 * ��1�ӵ�i�ĺ�
	 * @param i
	 * @return
	 */
	public static int sum(int i){
		if(i==1){
			return 1;
		}else{
			return sum(i-1)+i;
		}
	}
	/**
	 * ����i�Ľ׳�
	 * @param i
	 * @return
	 */
	public static long factorial(int i){
		if(i==1||i==2){
			return i;
		}else{
			return factorial(i-1)*i;
		}
	}
	public static void main(String[] args) {
		int i = 1;
		for(i=1;i<=20;i++){
			System.out.println("��"+i+"��쳲�������Ϊ:"+f(i));
			System.out.println("��1�ӵ�"+i+"�ĺͣ�"+sum(i));
			System.out.println(i+"�Ľ׳�Ϊ��"+factorial(i));
			System.out.println("****************************************");
		}
	}
}
