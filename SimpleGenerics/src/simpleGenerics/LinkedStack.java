package simpleGenerics;
/**
 * ����LinkdList��ʵ���ڲ���ʽ�洢����
 * @author Administrator
 *
 */
public class LinkedStack<T> {
	//�ڲ���Node<U>
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
	//ѹջ
	public void push(T item) {
		top = new Node<T>(item,top);
	}
	//��ջ
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
