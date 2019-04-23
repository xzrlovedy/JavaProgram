package genericsErased;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ��̬���Ͱ�ȫ��cat������뵽dog������
 * 
 * @author Administrator
 *
 */
public class CheckedList {
	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());// cat������뵽dog������
	}

	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1);	//��ʵȴ����һֻè
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
		try {
			oldStyleMethod(dogs2);  //�׳��쳣
		} catch (Exception e) {
			System.out.println(e);
		}
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
		pets.add(new Dog());
		pets.add(new Cat());
	}
}
