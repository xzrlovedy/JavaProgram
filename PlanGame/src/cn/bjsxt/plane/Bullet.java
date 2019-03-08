package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.bjsxt.util.Constant;

/**
 * �ӵ��࣬�����ĵ㷢���ӵ�
 * @author Administrator
 *
 */
public class Bullet{
	double x,y;
	int speed = 4;
	int width = 10;
	int height = 10;
	double degree;		//�ӵ����нǶ�
	
	/**
	 * ��ײ���μ����״
	 * @return
	 */
	public Rectangle getRect(){
		Rectangle r = new Rectangle((int)x,(int)y,width,height);
		return r;
	}
	
	/**
	 * �ӵ�������乹�췽��
	 */
	public Bullet(){
		//�ӵ�������нǶ�
		degree = Math.random()*Math.PI*2;
		//�ӵ��������ĵ�
		x= Constant.GAME_WIDTHN/2;
		y= Constant.GAME_HEIGHT/2;
	}
	
	/**
	 * �ӵ����й켣
	 * @param g
	 */
	public void draw(Graphics g){
		
		Color c = g.getColor();		//��ȡ��ǰ��ɫ
		g.setColor(Color.yellow);	//�ӵ���ɫ
		g.fillOval((int)x, (int)y, width, height);		//�ӵ���״
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		//�ӵ���ײ���߽�ص�
		if(y>Constant.GAME_HEIGHT-height||y<30){
			degree = -degree;
		}
		if(x<0||x>Constant.GAME_WIDTHN-width){
			degree = Math.PI-degree;
		}
		
		g.setColor(c);		//���ظı�ǰ��ɫ
	}
}
