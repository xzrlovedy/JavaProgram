package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.GameUtil;

public class Explode {
	double x,y;
	static Image[] imgs = new Image[6];
	int count;
	//��̬���Կ���ͨ����̬���������ʼ��
	static{
		for(int i=0;i<=5;i++){
			imgs[i] = GameUtil.getImage("explode/blast_0_"+(i+1)+".png");
			imgs[i].getWidth(null);
		}
	}
	
	public void draw(Graphics g){
		if(count<=5){
			g.drawImage(imgs[count],(int)x,(int)y,null);
			count++;
		}
	}
	public Explode(double x,double y){
		this.x = x;
		this.y = y;
	}
}
