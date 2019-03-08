package cn.xpu.hcp.tools;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

//�����ࣺ���ڻ�ͼ
public class GameImage {
	private GameImage() {};//������һ������Ϊ˽��
	public static Image getImage(String path) {
		URL u = GameImage.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
