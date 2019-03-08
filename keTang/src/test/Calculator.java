package test;

public class Calculator {
	public int jia(int a,int b){
		System.out.println(a+"+"+b+"="+(a+b));
		return 0;
	}
	public int jian(int a,int b){
		System.out.println(a+"-"+b+"="+(a-b));
		return 0;
	}
	public int chen(int a,int b){
		System.out.println(a+"*"+b+"="+(a*b));
		return 0;
	}
	public int chu(int a,int b){
		System.out.println(a+"/"+b+"="+(a/b));
		return 0;
	}
	public int xiangFanShu(int a){
		System.out.println(a+"的相反数："+(-a));
		return 0;
	}
	public int daoShu(int a){
		System.out.println(a+"的倒数："+(1.0/a));
		return 0;
	}
	public int jueDuiZhi(int a){
		if(a>=0){
			System.out.println(a+"的绝对值："+a);
			return 0;
		}else{
			System.out.println(a+"的绝对值："+(-a));
			return 0;
		}
	}
	public int max(int a,int b){
		if(a>b){
			System.out.println("两者最大为："+a);
			return 0;
		}else{
			System.out.println("两者最大为："+b);
			return 0;
		}
	}
	public int min(int a,int b){
		if(a<b){
			System.out.println("两者最小为："+a);
			return 0;
		}else{
			System.out.println("两者最小为："+b);
			return 0;
		}
	}
	public double jiSuanDouble(double d){
		double a = 0.5;
		int b = 0;
		if((d+a)<=(int)(d+1)){
			b = (int)d;
		}else{
			b = (int)(d+1);
		}
		System.out.println("大于或等于"+d+"的最小整数："+(int)(d+1));
		System.out.println("小于或等于"+d+"的最大整数："+(int)d);
		System.out.println("最接近"+d+"的整数值："+b);
		System.out.println(d+"的平方根："+Math.sqrt(d));
		System.out.println("自然对数log("+d+"):"+Math.log(d));
		return 0;
	}
	public double pow(double a,double b){
		System.out.println(a+"的"+b+"次方："+Math.pow(a, b));
		return 0;
	}
}
