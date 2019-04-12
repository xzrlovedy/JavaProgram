package regularExpression;

import java.util.regex.*;

public class Resetting {
	public static void main(String[] args) throws Exception{
		Matcher m = Pattern.compile("[frbw][aiu][gxt]")
				.matcher("fix the rug with bags");
		while(m.find()) {
			System.out.print(m.group()+" ");
			//���:fix rug wit bag
		}
		System.out.println();
		m.reset("fix the rig with rags");
		while(m.find()) {
			System.out.print(m.group()+" ");
			//���:fix rig wit rag
		}
	}
}
