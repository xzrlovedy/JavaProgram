package genericsErased;

import java.util.ArrayList;

/**
 * ���ڷ������ͱ����������ֱ����ǲ�ͬ�����ͣ�������ͬһ��
 * @author Administrator
 *
 */
public class ErasedTypeEquivalence {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
	    Class c1 = new ArrayList<String>().getClass();
	    Class c2 = new ArrayList<Integer>().getClass();
	    //String��Integer
	    System.out.println(c1 == c2);
	    //���Ϊtrue
	  }
}
