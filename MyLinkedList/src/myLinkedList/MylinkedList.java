package myLinkedList;
/**
 * 自定义实现LinkedList的简单功能
 * @author xzr
 *
 */
public class MylinkedList {
	private Node first;
	private Node last;
	private int size;
	/**
	 * 往链表里添加元素
	 * @param obj
	 */
	public void add(Object obj){
		Node n = new Node();
		if(first == null){
			n.setPrevious(null);
			n.setObj(obj);
			n.setNext(null);
			
			first = n;
			last = n;
		}else{
			n.setPrevious(last);
			n.setObj(obj);
			n.setNext(null);
			
			last.setNext(n);
			last = n;
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	/**
	 * 判断是否发生越界
	 * @param index
	 */
	private void rangeCheck(int index){
		if(index<0||index>=size){
			try{
				System.out.println("index越界！！！");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * 链表元素get方法
	 * @param index
	 * @return
	 */
	public Object get(int index){
		rangeCheck(index);
		Node temp = null;
		if(first == null){
			return null;
		}else{
			temp = first;
			for(int i=0;i<index;i++){
				temp = temp.next;
			}
		}
		return temp.obj;
	}
	//测试LinkedList的两个方法
	public static void main(String[] args) {
		MylinkedList list = new MylinkedList();
		list.add("aaa");
		list.add("bbb");
		System.out.println(list.size());
		System.out.println(list.get(0));
	}
}