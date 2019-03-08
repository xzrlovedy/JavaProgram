public class Class01{
	// 完成一个四则运算的功能
	public static void main(String args[]){
		for(int i=0;i<10;i++){
			if(i==3){
				continue ;//跳过本次循环 执行下一次循环
			}
			System.out.println("i = " + i);
		}
	}
}