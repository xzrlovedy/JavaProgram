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
		System.out.println(a+"���෴����"+(-a));
		return 0;
	}
	public int daoShu(int a){
		System.out.println(a+"�ĵ�����"+(1.0/a));
		return 0;
	}
	public int jueDuiZhi(int a){
		if(a>=0){
			System.out.println(a+"�ľ���ֵ��"+a);
			return 0;
		}else{
			System.out.println(a+"�ľ���ֵ��"+(-a));
			return 0;
		}
	}
	public int max(int a,int b){
		if(a>b){
			System.out.println("�������Ϊ��"+a);
			return 0;
		}else{
			System.out.println("�������Ϊ��"+b);
			return 0;
		}
	}
	public int min(int a,int b){
		if(a<b){
			System.out.println("������СΪ��"+a);
			return 0;
		}else{
			System.out.println("������СΪ��"+b);
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
		System.out.println("���ڻ����"+d+"����С������"+(int)(d+1));
		System.out.println("С�ڻ����"+d+"�����������"+(int)d);
		System.out.println("��ӽ�"+d+"������ֵ��"+b);
		System.out.println(d+"��ƽ������"+Math.sqrt(d));
		System.out.println("��Ȼ����log("+d+"):"+Math.log(d));
		return 0;
	}
	public double pow(double a,double b){
		System.out.println(a+"��"+b+"�η���"+Math.pow(a, b));
		return 0;
	}
}
