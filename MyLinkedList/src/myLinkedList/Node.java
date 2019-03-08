package myLinkedList;

/**
 * 表示一个节点
 * @author Administrator
 *
 */
public class Node{
	Node previous;	//上一个
	Object obj;			//本节点
	Node next;		//下一个
	
	public Node() {
		super();
	}

	public Node(Node previous, Object obj, Node next) {
		super();
		this.previous = previous;
		this.obj = obj;
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
