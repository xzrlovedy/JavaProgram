package newIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * �ٶȵ������������ʹ�õĽṹ���ӽ������ϵͳִ��I/O�ķ�ʽ��ͨ���ͻ�������
 * getChannel()�������һ��FileChannel��
 * @author Administrator
 *
 */
public class GetChannel {
	private static final int BSIZE = 1024;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			//д��
			FileChannel fc = new FileOutputStream("data.txt").getChannel();
			//���ֽڴ����ByteBuffer
			fc.write(ByteBuffer.wrap("some text ".getBytes()));
			fc.close();
			fc = new RandomAccessFile("data.txt","rw").getChannel();
			fc.position(fc.size());
			//���ֽڴ����ByteBuffer
			fc.write(ByteBuffer.wrap("some more".getBytes()));
			fc.close();
			//��ȡ
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
