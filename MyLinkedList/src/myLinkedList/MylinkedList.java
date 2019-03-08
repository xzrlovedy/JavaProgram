package myLinkedList;
/**
 * �Զ���ʵ��LinkedList�ļ򵥹���
 * @author xzr
 *
 */
public class MylinkedList {
	private Node first;
	private Node last;
	private int size;
	/**
	 * �����������Ԫ��
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
	 * �ж��Ƿ���Խ��
	 * @param index
	 */
	private void rangeCheck(int index){
		if(index<0||index>=size){
			try{
				System.out.println("indexԽ�磡����");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/**
	 * ����Ԫ��get����
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
	//����LinkedList����������
	public static void main(String[] args) {
		MylinkedList list = new MylinkedList();
		list.add("aaa");
		list.add("bbb");
		System.out.println(list.size());
		System.out.println(list.get(0));
	}
}