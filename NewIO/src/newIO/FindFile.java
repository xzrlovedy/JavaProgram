package newIO;

import java.io.File;

/**
 * 列出某个目录下的所有目录和文件
 * 
 * @author Administrator
 *
 */
public class FindFile {
	public static void main(String[] args) {
		File file = new File("D:\\视频");
		//判断目录是否存在
		if(!file.exists()) {
			System.out.println("目录不存在!");
			return;
		}
		File[] fileList = file.listFiles();
		for(int i = 0;i<fileList.length;i++) {
			//判断是否为目录
			if(fileList[i].isDirectory()) {
				System.out.println("目录："+fileList[i].getName());
			}else {
				System.out.println("文件："+fileList[i].getName());
			}
		}
	}
}
