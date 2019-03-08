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
	 * 加载窗口
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTHN,Constant.GAME_HEIGHT);
		setLocation(300,100);	// 窗口左上角坐标相对屏幕位置
		setVisible(true);	// 窗口可视化
		
		new PaintThread().start();	//启动重画线程
		
		// 窗口监听，使加载的窗口能关闭
		addWindowListener(new WindowAdapter(){
			// 重写windowClosing方法
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	/**
	 * 定义重画窗口线程类，是内部类
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
	//Java双缓冲，防止屏幕闪烁
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
