package objectSerialization;

import java.io.*;
import java.util.Random;

/**
 * �������л�
 * ���´����г���ʱ���ö��󽫱��ؽ�����ӵ�е���Ϣ���ϴ�����ʱ����ӵ�е���Ϣһ�¡�
 * 
 * ���������ͨ�������ӵĶ�������һ��Worm����棩�����л����ƽ��в��ԣ�
 * ÿ��������Worm����һ�����ӣ�ͬʱ�������ڲ�ͬ���ࣨData���Ķ���������������
 * @author Administrator
 *
 */
@SuppressWarnings("all")
//ʵ��Serializable�ӿڣ��������л��򵥴���
class Data implements Serializable{
	private int n;
	public Data(int n) {
		this.n=n;
	}
	public String toString() {
		return Integer.toString(n);
	}
}
//���
@SuppressWarnings("all")
public class Worm implements Serializable{
	private static Random rand = new Random(47);  //���������
	private Data[] d = {  //Data������������
		new Data(rand.nextInt(10)),	
		new Data(rand.nextInt(10)),	
		new Data(rand.nextInt(10))
	};
	private Worm next;  //��һ�������������
	private char c;
	//�������(int,char)
	public Worm(int i,char x) {
		System.out.println("Worm ��������"+i);
		c = x;
		if(--i>0) {
			next = new Worm(i,(char)(x+1));  //ÿ��������������һ������
		}
	}
	public Worm() {
		System.out.println("Worm Ĭ�Ϲ�����");
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder(":");
		result.append(c);
		result.append("(");
		for(Data dat:d) {  //��Data[]���ݷ���StringBuilder����
			result.append(dat);
		}
		result.append(")");
		if(next!=null) {  //���next��Ϊ��
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
