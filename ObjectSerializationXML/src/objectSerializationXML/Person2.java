package objectSerializationXML;

import java.util.ArrayList;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

/**
 * 从XML文件中反序列化Person对象
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class Person2 extends ArrayList<Person>{
	public Person2(String fileName) throws Exception{
		Document doc = new Builder().build(fileName);
		Elements elements = doc.getRootElement().getChildElements();
		for(int i=0;i<elements.size();i++) {
			add(new Person(elements.get(i)));
		}
	}
	public static void main(String[] args) {
		try {
			Person2 p = new Person2("People.xml");
			System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
