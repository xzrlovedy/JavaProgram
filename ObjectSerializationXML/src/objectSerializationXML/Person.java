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
 * �������л����ƣ���ֻ��java�Ľ��������ֻ��java���ܷ����л����ֶ���
 * �����в����Եķ�ʽ�ǽ�����ת��ΪXML��ʽ�����Ա����ָ�����ƽ̨������ʹ��
 * 
 * ������һ��Person�࣬�����ա��������л���XML
 * @author Administrator
 *
 */
@SuppressWarnings("all")
public class Person {
	private String first;
	private String last;
	//person������
	public Person(String first,String last) {
		this.first = first;
		this.last = last;
	}
	/*
	 * ʹ��XOM��������ת��ΪXML��Element�����person����
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
	 * ��XMLת��Ϊ�����пɶ��Ը�ʽ
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

