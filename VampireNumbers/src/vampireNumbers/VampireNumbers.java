package vampireNumbers;
/**
 * ====寻找吸血鬼数字====
 * 从《Thinking in Java》(中文第四版)中第4章的练习10看到“吸血鬼数字”，
 * 首先解释一下吸血鬼数字：吸血鬼数字是指位数为偶数的数字，可由一对数字相乘而得到，
 * 这对数字各包含乘积的一半位数的数字，以两个0结尾的数字是不允许的。
 * 四位数吸血鬼数字示例：1260=21*60，1827=21*87，2187=27*81……
 * @author 《Thinking in Java》
 *
 */
public class VampireNumbers {
	public static void main(String[] args) {
	    int[] startDigit = new int[4];	//存放两个乘数
	    int[] productDigit = new int[4];	//存放结果
	    for(int num1 = 10; num1 <= 99; num1++)
	      for(int num2 = num1; num2 <= 99; num2++) {
	        if((num1 * num2) % 9 != (num1 + num2) % 9)//吸血鬼数字特性
	          continue;
	        int product = num1 * num2;
	        startDigit[0] = num1 / 10;	//存放num1的十位数字
	        startDigit[1] = num1 % 10;	//存放num1的个位数字
	        startDigit[2] = num2 / 10;	//存放num2的十位数字
	        startDigit[3] = num2 % 10;	//存放num2的个位数字
	        productDigit[0] = product / 1000;	//存放product的千位数字
	        productDigit[1] = (product % 1000) / 100;	//存放product的百位数字
	        productDigit[2] = product % 1000 % 100 / 10;	//存放product的十位数字
	        productDigit[3] = product % 1000 % 100 % 10;	//存放product的个位数字
	        int count = 0;	
	        for(int x = 0; x < 4; x++)
	          for(int y = 0; y < 4; y++) {
	            if(productDigit[x] == startDigit[y]) {
	              count++;	//计数器，达到4，说明是吸血鬼数字
	              productDigit[x] = -1;
	              startDigit[y] = -2;
	              if(count == 4)
	                System.out.println(num1 + " * " + num2
	                  + " = " + product);
	            }
	          }
	      }
	  }
}
