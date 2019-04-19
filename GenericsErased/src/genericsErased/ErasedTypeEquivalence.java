package genericsErased;

import java.util.ArrayList;

/**
 * 由于泛型类型被擦除，两种本该是不同的类型，被当做同一种
 * @author Administrator
 *
 */
public class ErasedTypeEquivalence {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
	    Class c1 = new ArrayList<String>().getClass();
	    Class c2 = new ArrayList<Integer>().getClass();
	    //String与Integer
	    System.out.println(c1 == c2);
	    //结果为true
	  }
}
