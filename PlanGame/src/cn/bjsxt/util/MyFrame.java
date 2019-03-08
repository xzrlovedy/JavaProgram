package cn.bjsxt.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���ش���
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTHN,Constant.GAME_HEIGHT);
		setLocation(300,100);	// �������Ͻ����������Ļλ��
		setVisible(true);	// ���ڿ��ӻ�
		
		new PaintThread().start();	//�����ػ��߳�
		
		// ���ڼ�����ʹ���صĴ����ܹر�
		addWindowListener(new WindowAdapter(){
			// ��дwindowClosing����
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	/**
	 * �����ػ������߳��࣬���ڲ���
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try{
					Thread.sleep(40);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	//Java˫���壬��ֹ��Ļ��˸
	private Image iBuffer;
	private Graphics gBuffer;
	public void update(Graphics scr){
		if(iBuffer==null){
			iBuffer=createImage(this.getSize().width,this.getSize().height);
			gBuffer=iBuffer.getGraphics();
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
		paint(gBuffer);
		scr.drawImage(iBuffer,0,0,this);
	}
}
