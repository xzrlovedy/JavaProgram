package foreachAndIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/**
 * 双向迭代单词列表
 * @author Administrator
 *
 * @param <T>
 */
class ReversibleArrayList<T> extends ArrayList<T>{
	private static final long serialVersionUID = 1L;
	public ReversibleArrayList(Collection<T> c) {
		super(c);
	}
	//reversed()方法使列表反向
	public Iterable<T> reversed(){
		return new Iterable<T>() {
			public Iterator<T> iterator(){
				return new Iterator<T>() {
					int current = size()-1;
					public boolean hasNext() {return current>-1;}
					public T next() {return get(current--);}
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}

public class AdapterMethod {
	public static void main(String[] args) {
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>
				(Arrays.asList("To be or not to be".split(" ")));
		for(String s : ral) {//正向输出
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s : ral.reversed()) {//反向输出
			System.out.print(s+" ");
		}
	}
}
