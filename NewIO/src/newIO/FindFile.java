package newIO;

import java.io.File;

/**
 * �г�ĳ��Ŀ¼�µ�����Ŀ¼���ļ�
 * 
 * @author Administrator
 *
 */
public class FindFile {
	public static void main(String[] args) {
		File file = new File("D:\\��Ƶ");
		//�ж�Ŀ¼�Ƿ����
		if(!file.exists()) {
			System.out.println("Ŀ¼������!");
			return;
		}
		File[] fileList = file.listFiles();
		for(int i = 0;i<fileList.length;i++) {
			//�ж��Ƿ�ΪĿ¼
			if(fileList[i].isDirectory()) {
				System.out.println("Ŀ¼��"+fileList[i].getName());
			}else {
				System.out.println("�ļ���"+fileList[i].getName());
			}
		}
	}
}
