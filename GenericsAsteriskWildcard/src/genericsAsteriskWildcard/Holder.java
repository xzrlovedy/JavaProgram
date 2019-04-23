package genericsAsteriskWildcard;

import java.util.ArrayList;
import java.util.List;
/**
 * 泛型和通配符简单例子
 * @author Administrator
 *
 */
public class Holder<T> {
	private T value;
	
	public Holder() {
	}
	public Holder(T val) {
		value = val;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public boolean equals(Object obj) {
		return value.equals(obj);
	}
	@SuppressWarnings("all")
	public static void main(String[] args) {
		Holder<ArrayList> list_1 = new Holder<ArrayList>(new ArrayList());
		list_1.value.add("a");
		//Holder<List> list_3 = list_1;//报错
		Holder<? extends List> list_2 = list_1;//OK
		System.out.println(list_2.getValue());
	}
}
