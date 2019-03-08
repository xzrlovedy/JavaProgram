package com.myarraylist;

/**
 * 模拟实现JDK的ArrayList实现
 * @author xzr
 *
 */
public class MyArrayList {
	
	/**
	 * 用来存放Object对象
	 */
	Object[] value;
	int size;
	
	/**
	 * 构造器，初始是一个长度为16的Object数组
	 */
	public MyArrayList(){
		value = new Object[16];
	}
	public MyArrayList(int size){
		value = new Object[size];
	}
	
	/**
	 * 往容器里存放Object对象，size++：依次往数组后放
	 * @param obj
	 */
	public void add(Object obj){
		value[size] = obj;
		size++;
		if(size>=value.length){
			//容器装不下，扩容
			int newSize = value.length*2;
			Object[] newList =new Object[newSize];
			for(int i =0;i<value.length;i++){
				newList[i] = value[i];
			}
			value = newList;
		}
	}
	
	/**
	 * 从容器中取指定（index）位置的一个对象
	 * @param index
	 * @return
	 */
	public Object get(int index){
		if(index<0||index>=size){	//index在0到size-1之间,越界则抛出异常
			try {
				throw new Exception();	//手动抛出一个异常
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return value[index];
	}
	
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(2);
		list.add("xzr");
		list.add(new Man("徐泽荣"));
		list.add("123");
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
	}
	
}
