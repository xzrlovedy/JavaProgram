package newIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * 利用IO流实现字符串大小写转化
 * 
 * @author Administrator
 *
 */
public class ChangeInputStream extends FilterInputStream{

	protected ChangeInputStream(InputStream in) {
		super(in);
	}

	public int read() throws IOException{
		int c = 0;
		if((c = super.read()) != -1) {
			//把小写转化成大写
			if(Character.isLowerCase((char)c)) {
				return Character.toUpperCase((char)c);
			}
			//把大写转化成小写
			else if(Character.isUpperCase((char)c)) {
				return Character.toLowerCase((char)c);
			}
			//如果不是字母，则保持不变
			else {
				return c;
			}
		}else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int c;
		try {
			InputStream is = new ChangeInputStream(
					new BufferedInputStream(new FileInputStream("data.txt")));
			while((c = is.read())>=0) {
				System.out.print((char)c);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
