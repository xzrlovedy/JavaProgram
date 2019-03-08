package cn.bjsxt.util;

import java.awt.Image;
import java.awt.Toolkit;

public class GameUtil {
	//工具类最好将构造器私有
	private GameUtil(){}
	//加载图片
	public static Image getImage(String path){
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
	}
}
