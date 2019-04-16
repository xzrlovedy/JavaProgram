package simpleGenerics;
/**
 * 不用LinkdList来实现内部链式存储机制
 * @author Administrator
 *
 */
public class LinkedStack<T> {
	//内部类Node<U>
	private static class Node<U>{
		U item;
		Node<U> next;
		Node(){
			item = null;
			next = null;
		}
		Node(U item,Node<U> next){
			this.item = item;
			this.next = next;
		}
		boolean end() {
			return item==null&&next==null;
		}
	}
	private Node<T> top = new Node<T>();
	//压栈
	public void push(T item) {
		top = new Node<T>(item,top);
	}
	//出栈
	public T pop() {
		T result = top.item;
		if(!top.end()) {
			top = top.next;
		}
		return result;
	}
	public static void main(String[] args) {
		LinkedStack<String> ls = new LinkedStack<String>();
		for(String s : "user defined stack".split(" ")) {
			ls.push(s);
		}
		String t;
		while((t = ls.pop()) != null) {
			System.out.println(t);
		}
	}
}
