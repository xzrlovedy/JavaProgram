package newIO;

import java.nio.ByteBuffer;

/**
 * 获取基本类型
 * 如何使用这些方法来插入和抽取各种数值
 * @author Administrator
 *
 */
public class GetData {
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		System.out.println("**************************");
		int i= 0;
		while(i++ < bb.limit()) {
			if(bb.get() != 0) {
				System.out.println("nonzero");
			}
		}
		System.out.println("i="+i);
		bb.rewind();
		System.out.println("**************************");
		bb.asCharBuffer().put("XZR");
		char c;
		while((c = bb.getChar())!=0) {
			System.out.print(c+"");
		}
		System.out.println();
		bb.rewind();
		System.out.println("**************************");
		bb.asShortBuffer().put((short)456789);
		System.out.println(bb.getShort());
		bb.rewind();
		System.out.println("**************************");
		bb.asIntBuffer().put(3456789);
		System.out.println(bb.getInt());
		bb.rewind();
	}
}
