package simpleGenerics;

public class Holder<T> {
	private T t;
	public Holder(T t){
		this.t = t;
	}
	public void set(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
	public static void main(String[] args) {
		Holder<String> h = new Holder<String>("SimpleGenerics");
		System.out.println(h.get());
		h.set("gengerics");
		System.out.println(h.get());
		//h.set(123); 只能放String对象
	}
}
