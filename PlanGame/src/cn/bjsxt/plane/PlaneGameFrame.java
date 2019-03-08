package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;

/**
 * �ɻ���Ϸ���ڣ��̳�MyFrame��
 * 
 * @author xzr
 * 
 */
public class PlaneGameFrame extends MyFrame {
	private static final long serialVersionUID = 1L;
	
	Image bg = GameUtil.getImage("images/bg.jpg"); // ���ر���ͼƬ
	Plan p = new Plan("images/plan.png", 100, 100);
	
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();//����������ӵ�����,�����Ժ��
	
	Date startTime;		//��Ϸ��ʼʱ��
	Date endTime;		//����ʱ��
	
	Explode bao;		//�ɻ���ը����

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		
		//���·�launchFrame�����ɵ��ӵ����ڻ����ϣ����ñ����ķ�ʽ
		for(int i=0;i<bulletList.size();i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//�ɻ����ӵ���ײ���
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng){
				p.setLive(false);//�ɻ�����
				if(bao == null){
					endTime = new Date();
					bao = new Explode(p.x,p.y);
				}
				bao.draw(g);
			}
		}
		if(!p.isLive()){
			Color c = g.getColor();
			g.setColor(Color.white);
			Font f = new Font("����",Font.BOLD,50);
			g.setFont(f);
			g.drawString("GAME OVER", Constant.GAME_WIDTHN/2-100,Constant.GAME_HEIGHT/2);//������������
			Font f1 = new Font("����",Font.BOLD,20);
			g.setFont(f1);
			long period = (endTime.getTime()-startTime.getTime())/1000;		//��������ʱ�䣬����/1000
			g.drawString("����ʱ��"+period+"��",Constant.GAME_WIDTHN/2-100,Constant.GAME_HEIGHT/2+50);
			g.setColor(c);
		}
	}

	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}

	/**
	 * ��д�����launchFrame����������������ļ��̼���
	 * ��Ϸ��ʼ�����ش���
	 */
	public void launchFrame() {
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		//�����ӵ�,�ŵ�������
		for(int i=0;i<30;i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
	}

	/**
	 * �����ڲ��࣬���Է����ʹ���ⲿ������� �˷����������̶��������Ʒɻ��ƶ�
	 * 
	 * @author Administrator
	 * 
	 */
	class KeyMonitor extends KeyAdapter {

		/**
		 * ���̰��¼���
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("���£�" + e.getKeyCode());
			// ���������ƶ�
			p.addDirection(e);
		}

		/**
		 * ���̰�ť�������
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}
	}
}
