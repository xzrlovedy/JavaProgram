package test2;

public class WuMingFen {
	String theMa;//����
	int quantity;//�۵ķ���(��)
	boolean likeSoup;//�Ƿ����
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
		System.out.println("******�鿴���******");
		System.out.println("���룺"+theMa);
		System.out.println("�۵ķ�����"+quantity+"��");
		System.out.println("�Ƿ������"+likeSoup);
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		WuMingFen f1 = new WuMingFen("ţ��",3,true);
		 @SuppressWarnings("unused")
		WuMingFen f2 = new WuMingFen("ţ��",2);
		WuMingFen f3 = new WuMingFen();
		f3.theMa = "����";
		f3.quantity = 2;
		f3.likeSoup = true;
		f3.check();
	}
}
