package javaArithmetic;
/**
 * 递归经典算法
 * @author Administrator
 *
 */
public class Recursion {
	/**
	 * 斐波那契数列，返回第i个元素的值
	 * @param i 第i个元素
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
	 * 从1加到i的和
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
	 * 计算i的阶乘
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
			System.out.println("第"+i+"个斐波那契数为:"+f(i));
			System.out.println("从1加到"+i+"的和："+sum(i));
			System.out.println(i+"的阶乘为："+factorial(i));
			System.out.println("****************************************");
		}
	}
}
