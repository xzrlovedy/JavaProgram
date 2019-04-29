package objectSerialization;

import java.io.*;
import java.util.Random;

/**
 * 对象序列化
 * 在下次运行程序时，该对象将被重建并且拥有的信息与上次运行时它所拥有的信息一致。
 * 
 * 下面的例子通过对链接的对象生成一个Worm（蠕虫）对序列化机制进行测试，
 * 每个对象都与Worm的下一段链接，同时又与属于不同的类（Data）的对象引用数组链接
 * @author Administrator
 *
 */
@SuppressWarnings("all")
//实现Serializable接口，对象序列化简单处理
class Data implements Serializable{
	private int n;
	public Data(int n) {
		this.n=n;
	}
	public String toString() {
		return Integer.toString(n);
	}
}
//蠕虫
@SuppressWarnings("all")
public class Worm implements Serializable{
	private static Random rand = new Random(47);  //产生随机数
	private Data[] d = {  //Data对象引用数组
		new Data(rand.nextInt(10)),	
		new Data(rand.nextInt(10)),	
		new Data(rand.nextInt(10))
	};
	private Worm next;  //下一个蠕虫引用属性
	private char c;
	//构造蠕虫(int,char)
	public Worm(int i,char x) {
		System.out.println("Worm 构造器："+i);
		c = x;
		if(--i>0) {
			next = new Worm(i,(char)(x+1));  //每个对象都与蠕虫的下一段链接
		}
	}
	public Worm() {
		System.out.println("Worm 默认构造器");
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder(":");
		result.append(c);
		result.append("(");
		for(Data dat:d) {  //将Data[]数据放入StringBuilder容器
			result.append(dat);
		}
		result.append(")");
		if(next!=null) {  //如果next不为空
			result.append(next);
		}
		return result.toString();
	}
	
	public static void main(String[] args) 
	throws ClassNotFoundException,IOException{
		Worm w = new Worm(6,'a');
		System.out.println("w = "+w);
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("worm.out"));
		out.writeObject("Worm storage\n");
		out.writeObject(w);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("worm.out"));
		String s = (String)in.readObject();
		Worm w2 = (Worm)in.readObject();
		System.out.println(s+"w2 = "+w2);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(bout);
		out2.writeObject("Worm storage\n");
		out2.writeObject(w);
		out2.flush();
		
		ObjectInputStream in2 = new ObjectInputStream(
				new ByteArrayInputStream(bout.toByteArray()));
		s = (String)in2.readObject();
		Worm w3 = (Worm)in2.readObject();
		System.out.println(s+"w3 = "+w3);
	}
}
