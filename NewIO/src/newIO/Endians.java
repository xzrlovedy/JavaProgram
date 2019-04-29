package newIO;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * 通过字节存放模式设置来改变字符中的字节次序
 * @author Administrator
 *
 */
public class Endians {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
		//byte[12]：只能put六个字母
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
