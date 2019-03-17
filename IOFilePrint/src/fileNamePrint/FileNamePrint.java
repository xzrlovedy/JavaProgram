package fileNamePrint;

import java.io.File;

/**
 * 输出子孙级目录|文件的名称(绝对路径) 
 * 1、listFiles() 
 * 2、递归
 * 
 * @author Administrator
 *
 */
public class FileNamePrint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "D:/MineCraft/PVP_1.8.9";//选择文件夹
		File parent = new File(path);
		printName(parent);
	}

	/**
	 * 输出路径
	 */
	public static void printName(File src) {
		if (null == src || !src.exists()) {//判断文件夹是否为空
			return;
		}
		System.out.println(src.getAbsolutePath());
		if (src.isDirectory()) { // 文件夹
			for (File sub : src.listFiles()) {
				printName(sub);//递归
			}
		}
	}

}