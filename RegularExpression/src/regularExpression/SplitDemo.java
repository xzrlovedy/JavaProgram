package regularExpression;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitDemo {
	public static void main(String[] args) {
		String s = "Once you have an object "+
				"representing a compiled regular expression, "+
				"what do you do with it?";
		System.out.println(Arrays.toString(Pattern.compile("a").split(s)));
		System.out.println(Arrays.toString(Pattern.compile("a").split(s,3)));
		System.out.println(Arrays.toString(s.split(" ")));
	}
}