package genericsAndArray;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
	@SuppressWarnings("all")
	public static void main(String[] args) {
	    List<String>[] ls;
	    List[] la = new List[10];
	    ls = (List<String>[])la; // "Unchecked" warning
	    ls[0] = new ArrayList<String>();
	    
	    Object[] objects = ls; // So assignment is OK
	    objects[1] = new ArrayList<Integer>();
	  }
}
