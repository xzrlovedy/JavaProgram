package javaArithmetic;
/**
 * 煤球数目
 * 有一堆煤球，堆成三角棱锥形。具体：
 * 第一层放1个，
 * 第二层3个（排列成三角形），
 * 第三层6个（排列成三角形），
 * 第四层10个（排列成三角形），
 * ....
 * 如果一共有100层，共有多少个煤球？
 * @author XZR
 *
 */
public class NumberOfCoal {
	public static void main(String[] args) {
		NumberOfCoal nc = new NumberOfCoal();
		System.out.println("第100层总个数："+nc.calculate(100));
	}
	//输入层数，计算个数
	public int calculate(int tier){
		int sum = 0;//总个数
		int j = 0;//i是层数，j是每层的个数
		for(int i = 1;i<=tier;i++){
			j += i;
			sum += j;
		}
		return sum;
	}
}
