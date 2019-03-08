package cn.bjsxt.util;

import java.awt.Image;
import java.awt.Toolkit;

public class GameUtil {
	//��������ý�������˽��
	private GameUtil(){}
	//����ͼƬ
	public static Image getImage(String path){
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
