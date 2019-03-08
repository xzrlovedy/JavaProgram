package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.bjsxt.util.Constant;

/**
 * 子弹类，由中心点发射子弹
 * @author Administrator
 *
 */
public class Bullet{
	double x,y;
	int speed = 4;
	int width = 10;
	int height = 10;
	double degree;		//子弹飞行角度
	
	/**
	 * 碰撞矩形检测形状
	 * @return
	 */
	public Rectangle getRect(){
		Rectangle r = new Rectangle((int)x,(int)y,width,height);
		return r;
	}
	
	/**
	 * 子弹随机发射构造方法
	 */
	public Bullet(){
		//子弹随机飞行角度
		degree = Math.random()*Math.PI*2;
		//子弹生成中心点
		x= Constant.GAME_WIDTHN/2;
		y= Constant.GAME_HEIGHT/2;
	}
	
	/**
	 * 子弹飞行轨迹
	 * @param g
	 */
	public void draw(Graphics g){
		
		Color c = g.getColor();		//获取当前颜色
		g.setColor(Color.yellow);	//子弹颜色
		g.fillOval((int)x, (int)y, width, height);		//子弹形状
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		//子弹碰撞到边界回弹
		if(y>Constant.GAME_HEIGHT-height||y<30){
			degree = -degree;
		}
		if(x<0||x>Constant.GAME_WIDTHN-width){
			degree = Math.PI-degree;
		}
		
		g.setColor(c);		//返回改变前颜色
	}
}
