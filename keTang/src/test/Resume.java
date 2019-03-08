package test;

public class Resume {
	String xm;// 姓名
	String xb;;// 性别
	int nl;// 年龄
	String jtzz;// 家庭住址
	String xl;// 学历
	public static void main(String[] args) {
		Resume xzr=new Resume();
		xzr.xm="徐泽荣";
		xzr.xb="男";
		xzr.nl=21;
		xzr.jtzz="江西赣州";
		xzr.xl="本科";
		System.out.println("姓名："+xzr.xm+"\n性别："+xzr.xb+"\n年龄："+xzr.nl+
				"\n家庭住址："+xzr.jtzz+"\n学历："+xzr.xl);
	}
}
	
