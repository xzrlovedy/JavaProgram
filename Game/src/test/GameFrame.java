package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ��Ϸ����
 * @author xzr
 *
 */
@SuppressWarnings("serial")
public class GameFrame extends Frame {//AWT��Ҫ��GUI��̣�������̭��java���ʺ�д�������
	
	Image img = GameUtil.getImage("image/feiji.png");
	
	
	/**
	 * ���ش��ڣ��������������Ͻ�Ϊ����
	 */
	public void launchFrame(){
		setSize(500,500);//���ڿ��
		setLocation(100,100);//�������Ͻ����������Ļλ��
		setVisible(true);//���ڿ��ӻ�
		
		new PaintThread().start();//�����ػ��߳�
		
		/**
		 * ���ڼ�����ʹ���صĴ����ܹر�
		 */
		addWindowListener(new WindowAdapter(){

			@Override//��дwindowClosing����
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	//����ͼƬ�ĺ�������
	int x=300,y=1;
	
	/**
	 * ��д���෽��paint��ʹ���س��Ĵ����ܻ��������ص�����̬�����ã�main��������ã��Զ�ִ�С�
	 * ������Ԫ�ص���������ڴ������Ͻǣ���������Ļ������
	 * �߳�������˷������������ã�new PaintThread().start();//�����ػ��߳�
	 */
	@Override
	public void paint(Graphics g) {
		g.drawRect(100, 100, 200, 200);//�ڴ��ڻ����Σ�������Դ���
		g.drawOval(100, 100, 200, 200);//��������Բ
		
		//����ͼƬ
	    g.drawImage(img, x, y, null);
	    x-=3;
	    y+=2;
	    
		//��������
		Font f = new Font("����",Font.BOLD,50);//���幹����
		g.setFont(f);
		g.drawString("��Ϸ����", 200, 120);
		
		//��������
		Color c = g.getColor();//�����ʼ��ɫ
		g.setColor(Color.blue);//������ɫ
		g.fillRect(100, 100, 20, 20);//������
		g.setColor(c);//��ԭ��ʼ��ɫ�������Ժ����
	}
	
	/**
	 * ʹ���ص�ͼƬ������������һ���ػ����ڵ��߳��ࡣ
	 * ��д����run������
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread{
		
		public void run(){
			while(true){
				repaint();//�ػ�����
				try {
					Thread.sleep(40);//cpu��Ϣ40����
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();//������Ϸ���ڶ���
		gf.launchFrame();//���ü��ش��ں���
	}
}
