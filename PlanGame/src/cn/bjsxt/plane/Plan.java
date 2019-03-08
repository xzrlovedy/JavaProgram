package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import cn.bjsxt.util.GameUtil;

/**
 * �ɻ���
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
	 * ��ײ���μ����״
	 * @return
	 */
	public Rectangle getRect(){
		Rectangle r = new Rectangle((int)x,(int)y,img.getWidth(null)-10,img.getHeight(null)-10);
		return r;
	}
	
	/**
	 * ���ض�λ�ü��طɻ�ͼƬ��live״̬Ĭ��Ϊtrue�����live����false���ɻ����������ڼ���ͼƬ
	 * @param g
	 */
	public void draw(Graphics g){
		if(live){
			g.drawImage(img,(int)x,(int)y,null);
			move();
		}
		
	}

	/**
	 * �ɻ��ƶ�����
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
	 * �ɻ����򰴼����Ʒ���---����
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
	//ͬ��
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
		this.img = GameUtil.getImage(imgPath);	//���طɻ�ͼƬ
		this.x = x;
		this.y = y;
	}
	public void plan(){
		
	}
	
}
