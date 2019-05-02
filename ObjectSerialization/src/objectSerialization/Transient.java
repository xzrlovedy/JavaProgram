package objectSerialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * transient��˲ʱ���ؼ���
 * �����л������У�������Externalizable����ֻ�����貿�ֽ�����ʾ�����л���
 * �����Serializable�������Σ����е����л����������Զ��Ľ��У�Ϊ���ܹ�
 * ������ƣ�������transient��˲ʱ���ؼ��������ֶιر����л�
 * @author Administrator
 *
 */
public class Transient implements Serializable{
	private Date date = new Date();
	private String username;
	private transient String password;
	public Transient(String name,String pwd) {
		username = name;
		password = pwd;
	}
	public String toString() {
		return "Transient info:\n	uesrname: "+username+
				"\n	date: "+date+"\n	password: "+password;
	}
	
	public static void main(String[] args) throws Exception{
		Transient t = new Transient("xzr","123");
		System.out.println("Transient t ="+t);
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("Transient.txt"));
		out.writeObject(t);
		out.close();
		TimeUnit.SECONDS.sleep(1);
		
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("Transient.txt"));
		System.out.println("�ָ� object "+new Date());
		t = (Transient)in.readObject();
		System.out.println("Transient t ="+t);
	}
}
