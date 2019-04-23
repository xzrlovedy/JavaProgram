package genericsErased;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 动态类型安全，cat对象放入到dog容器中
 * 
 * @author Administrator
 *
 */
public class CheckedList {
	@SuppressWarnings("unchecked")
	static void oldStyleMethod(List probablyDogs) {
		probablyDogs.add(new Cat());// cat对象放入到dog容器中
	}

	public static void main(String[] args) {
		List<Dog> dogs1 = new ArrayList<Dog>();
		oldStyleMethod(dogs1);	//其实却接收一只猫
		List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
		try {
			oldStyleMethod(dogs2);  //抛出异常
		} catch (Exception e) {
			System.out.println(e);
		}
		List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
		pets.add(new Dog());
		pets.add(new Cat());
	}
}
