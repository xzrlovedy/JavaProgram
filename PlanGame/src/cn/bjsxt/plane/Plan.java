package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import cn.bjsxt.util.GameUtil;

/**
 * 飞机类
 * @author Administrator
 *
 */
public class Plan{
	Image img;
	double x,y;
	int speed = 10;
	int width;
	int height;
	private boolean left,up,right,down;
	private boolean live = true;
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	/**
	 * 碰撞矩形检测形状
	 * @return
	 */
	public Rectangle getRect(){
		Rectangle r = new Rectangle((int)x,(int)y,img.getWidth(null)-10,img.getHeight(null)-10);
		return r;
	}
	
	/**
	 * 在特定位置加载飞机图片，live状态默认为true，如果live等于false，飞机死亡，不在加载图片
	 * @param g
	 */
	public void draw(Graphics g){
		if(live){
			g.drawImage(img,(int)x,(int)y,null);
			move();
		}
		
	}

	/**
	 * 飞机移动方法
	 */
	public void move(){
		if(left){
			x-=speed;
		}
		if(right){
			x+=speed;
		}
		if(up){
			y-=speed;
		}
		if(down){
			y+=speed;
		}
	}
	/**
	 * 飞机方向按键控制方法---按下
	 * @param e
	 */
	public void addDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}
	//同上
	public void minusDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
	}
	
	public Plan(String imgPath, double x, double y) {
		super();
		this.img = GameUtil.getImage(imgPath);	//加载飞机图片
		this.x = x;
		this.y = y;
	}
	public void plan(){
		
	}
	
}
