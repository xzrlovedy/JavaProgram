package test2;

public class Test {
	public static void main(String[] args) {
		Man m=new Man();
		m.name = "Jack";
		m.age = 20;
		m.sex = "��";
		m.show();
		m.man();
		System.out.println("*********************");
		Human h=new Woman();//��ת�Ͷ���
		h.name = "Lucy";
		h.age = 21;
		h.show();//ֻ��Human������Ժͷ���
	}
}
