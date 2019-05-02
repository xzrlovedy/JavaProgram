package objectSerialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 序列化的控制
 * 通过实现Externalizable接口代替Serializable接口来对序列化过程进行控制
 * @author Administrator
 *
 */

class Blip1 implements Externalizable{
	public Blip1() {
		System.out.println("Blip1 构造器");
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal");
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip1.readExternal");
	}
}

class Blip2 implements Externalizable{
	Blip2() {
		System.out.println("Blip2 构造器");
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal");
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip2.readExternal");
	}
}

public class Blips {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		System.out.println("Constructing objects: ");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("Blips.txt"));
		System.out.println("保存 objects: ");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("Blips.txt"));
		System.out.println("恢复 b1:");
		b1 = (Blip1)in.readObject();
		System.out.println("恢复 b2:");
		//b2恢复异常，构造器不是public
		b2 = (Blip2)in.readObject();
	}
}
