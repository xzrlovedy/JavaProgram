package genericsMethods;
/**
 * ���ͷ���ʾ��
 * @author Administrator
 *
 */
public class Demo {
	//��ӡT�����ͣ�T����ʱ����
	public <T> void f(T x) {
	    System.out.println(x.getClass().getName());
	  }
	  public static void main(String[] args) {
	    Demo gm = new Demo();
	    gm.f("");
	    gm.f(1);
	    gm.f(1.0);
	    gm.f(1.0F);
	    gm.f('c');
	    gm.f(gm);
	  }
}
