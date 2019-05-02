package objectSerialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * transient（瞬时）关键字
 * 在序列化过程中，可以用Externalizable对象只对所需部分进行显示的序列化。
 * 如果是Serializable对象该如何？所有的序列化操作都会自动的进行，为了能够
 * 给予控制，可以用transient（瞬时）关键字修饰字段关闭序列化
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
		System.out.println("恢复 object "+new Date());
		t = (Transient)in.readObject();
		System.out.println("Transient t ="+t);
	}
}
