package newIO;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * ͨ��IntBuffer����ByteBuffer�е�int��������
 * @author Administrator
 *
 */
public class IntBufferDemo {
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();
		
		ib.put(new int[] {11,13,3,34,12,543,367});
		System.out.println(ib.get(3));
		ib.put(3, 1811);
		ib.flip();
		while(ib.hasRemaining()) {
			int i = ib.get();
			System.out.println(i);
		}
	}
}
