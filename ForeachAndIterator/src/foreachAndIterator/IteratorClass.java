package foreachAndIterator;

import java.util.Iterator;

/**
 * Interable½Ó¿Ú±éÀúÈİÆ÷
 * @author Administrator
 *
 */

public class IteratorClass implements Iterable<String>{
	protected String[] words = ("Take the long way home".split(" "));
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int index = 0;
			public boolean hasNext() {
				return index<words.length;
			}
			public String next() {
				return words[index++];
			}
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	public static void main(String[] args) {
		for(String s : new IteratorClass()) {
			System.out.print(s+" ");
		}
	}
}
