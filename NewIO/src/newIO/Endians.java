package newIO;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * ͨ���ֽڴ��ģʽ�������ı��ַ��е��ֽڴ���
 * @author Administrator
 *
 */
public class Endians {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
		//byte[12]��ֻ��put������ĸ
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		bb.rewind();
		
		bb.order(ByteOrder.BIG_ENDIAN);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		bb.rewind();
		
		bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
	}
}
