package ioByteArray;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1、文件->程序->字节数组 
 * 文件输入流:FileInputStream 
 * 字节数组输出流:ByteArrayOutputStream
 *
 * 2、字节数组->程序->文件 
 * 字节数组输入流:ByteArrayInputStream 
 * 文件输出流:FileOutputStream
 *
 * @author Administrator
 *
 */
public class ByteArray {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		byte[] data = getBytesFromFile("D:/MineCraft/mc1.jpg");
		toFileFromByteArray(data, "D:/MineCraft/mc3.jpg");
	}

	/**
	 * 2、字节数组->程序->文件
	 */
	public static void toFileFromByteArray(byte[] src, String destPath) throws IOException {
		// 创建源
		// 目的地
		File dest = new File(destPath);

		// 选择流
		// 字节数组输入流
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		// 文件输出流
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));

		// 操作 不断读取字节数组
		byte[] flush = new byte[1];
		int len = 0;
		while (-1 != (len = is.read(flush))) {
			// 写出到文件中
			os.write(flush, 0, len);
		}
		os.flush();

		// 释放资源
		os.close();
		is.close();

	}

	/**
	 * 1、文件->程序->字节数组
	 * 
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesFromFile(String srcPath) throws IOException {
		// 创建文件源
		File src = new File(srcPath);
		// 创建字节数组目的地
		byte[] dest = null;

		// 选择流
		// 文件输入流
		InputStream is = new BufferedInputStream(new FileInputStream(src));
		// 字节数组输出流 不能使用多态
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		// 操作 不断读取文件 写出到字节数组流中
		byte[] flush = new byte[1024];
		int len = 0;
		while (-1 != (len = is.read(flush))) {
			// 写出到字节数组流中
			bos.write(flush, 0, len);
		}
		bos.flush();

		// 获取数据
		dest = bos.toByteArray();

		bos.close();
		is.close();
		return dest;
	}

}
