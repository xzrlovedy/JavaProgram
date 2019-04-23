package genericsAsteriskWildcard;
/**
 * ²¶»ñ×ª»»
 * @author Administrator
 *
 */
public class CaptureConversion {
	static <T> void f1(Holder<T> holder) {
	    T t = holder.getValue();
	    System.out.println(t.getClass().getSimpleName());
	  }
	  static void f2(Holder<?> holder) {
	    f1(holder);
	  }	
	  @SuppressWarnings("unchecked")
	  public static void main(String[] args) {
	    Holder raw = new Holder<Integer>(1);
	    // f1(raw); // Produces warnings
	    f2(raw); // No warnings
	    Holder rawBasic = new Holder();
	    rawBasic.setValue(new Object()); // Warning
	    f2(rawBasic); // No warnings
	    Holder<?> wildcarded = new Holder<Double>(1.0);
	    f2(wildcarded);
	  }
}
