package newIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * ����IO��ʵ���ַ�����Сдת��
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
			//��Сдת���ɴ�д
			if(Character.isLowerCase((char)c)) {
				return Character.toUpperCase((char)c);
			}
			//�Ѵ�дת����Сд
			else if(Character.isUpperCase((char)c)) {
				return Character.toLowerCase((char)c);
			}
			//���������ĸ���򱣳ֲ���
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
