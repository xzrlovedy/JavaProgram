package newIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 速度的提高来自于所使用的结构更接近与操作系统执行I/O的方式：通道和缓冲器。
 * getChannel()将会产生一个FileChannel。
 * @author Administrator
 *
 */
public class GetChannel {
	private static final int BSIZE = 1024;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			//写入
			FileChannel fc = new FileOutputStream("data.txt").getChannel();
			//将字节存放于ByteBuffer
			fc.write(ByteBuffer.wrap("some text ".getBytes()));
			fc.close();
			fc = new RandomAccessFile("data.txt","rw").getChannel();
			fc.position(fc.size());
			//将字节存放于ByteBuffer
			fc.write(ByteBuffer.wrap("some more".getBytes()));
			fc.close();
			//读取
			fc = new FileInputStream("data.txt").getChannel();
			ByteBuffer buff = ByteBuffer.allocate(BSIZE);
			fc.read(buff);
			buff.flip();
			while(buff.hasRemaining()) {
				System.out.print((char)buff.get());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
