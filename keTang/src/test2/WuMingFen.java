package test2;

public class WuMingFen {
	String theMa;//面码
	int quantity;//粉的分量(两)
	boolean likeSoup;//是否带汤
	public WuMingFen(String theMa,int quantity,boolean likeSoup){
		this.theMa = theMa;
		this.quantity = quantity;
		this.likeSoup = likeSoup;
	}
	public WuMingFen(String theMa,int quantity){
		this.theMa = theMa;
		this.quantity = quantity;
	}
	public WuMingFen() {
		// TODO Auto-generated constructor stub
	}
	public void check(){
		System.out.println("******查看面板******");
		System.out.println("面码："+theMa);
		System.out.println("粉的分量："+quantity+"两");
		System.out.println("是否带汤："+likeSoup);
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		WuMingFen f1 = new WuMingFen("牛肉",3,true);
		 @SuppressWarnings("unused")
		WuMingFen f2 = new WuMingFen("牛肉",2);
		WuMingFen f3 = new WuMingFen();
		f3.theMa = "酸辣";
		f3.quantity = 2;
		f3.likeSoup = true;
		f3.check();
	}
}
