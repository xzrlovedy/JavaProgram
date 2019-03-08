package com.myarraylist;

/**
 * ģ��ʵ��JDK��ArrayListʵ��
 * @author xzr
 *
 */
public class MyArrayList {
	
	/**
	 * �������Object����
	 */
	Object[] value;
	int size;
	
	/**
	 * ����������ʼ��һ������Ϊ16��Object����
	 */
	public MyArrayList(){
		value = new Object[16];
	}
	public MyArrayList(int size){
		value = new Object[size];
	}
	
	/**
	 * ����������Object����size++��������������
	 * @param obj
	 */
	public void add(Object obj){
		value[size] = obj;
		size++;
		if(size>=value.length){
			//����װ���£�����
			int newSize = value.length*2;
			Object[] newList =new Object[newSize];
			for(int i =0;i<value.length;i++){
				newList[i] = value[i];
			}
			value = newList;
		}
	}
	
	/**
	 * ��������ȡָ����index��λ�õ�һ������
	 * @param index
	 * @return
	 */
	public Object get(int index){
		if(index<0||index>=size){	//index��0��size-1֮��,Խ�����׳��쳣
			try {
				throw new Exception();	//�ֶ��׳�һ���쳣
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value[index];
	}
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(2);
		list.add("xzr");
		list.add(new Man("������"));
		list.add("123");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
	}
	
}
