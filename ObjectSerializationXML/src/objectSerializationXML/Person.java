package objectSerializationXML;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

/**
 * 对象序列化限制，它只是java的解决方案，只有java才能反序列化这种对象，
 * 更具有操作性的方式是将数据转换为XML格式，可以被各种各样的平台和语言使用
 * 
 * 假设有一个Person类，包含姓、名，序列化到XML
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class Person {
	private String first;
	private String last;
	//person构造器
	public Person(String first,String last) {
		this.first = first;
		this.last = last;
	}
	/*
	 * 使用XOM来产生被转换为XML的Element对象的person数据
	 */
	public Element getXML() {
		Element person = new Element("person");
		Element firstName = new Element("first");
		firstName.appendChild(first);
		Element lastName = new Element("last");
		lastName.appendChild(last);
		
		person.appendChild(firstName);
		person.appendChild(lastName);
		return person;
	}
	
	public Person(Element person) {
		first = person.getFirstChildElement("first").getValue();
		last = person.getFirstChildElement("last").getValue();
	}
	public String toString() {
		return first+" "+last;
	}
	/*
	 * 将XML转换为更具有可读性格式
	 */
	public static void format(OutputStream os,Document doc) throws Exception{
		Serializer serializer = new Serializer(os,"ISO-8859-1");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();
	}
	public static void main(String[] args) {
		List<Person> pers = new ArrayList<Person>();
		pers.add(new Person("Gonzo","Fry"));
		pers.add(new Person("X","ZR"));
		pers.add(new Person("J","WJ"));
		System.out.println(pers);
		
		Element root = new Element("pers");
		for(Person p : pers) {
			root.appendChild(p.getXML());
		}
		Document doc = new Document(root);
		try {
			format(System.out, doc);
			format(new BufferedOutputStream(new FileOutputStream("People.xml")),doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

