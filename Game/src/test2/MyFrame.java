package test2;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * MyFrame封装类，游戏常用方法
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
public class MyFrame extends Frame {

	Constant c = new Constant();
	// 加载窗口函数
	public void launchFrame() {
		setSize(c.Game_Width, c.Game_Heigth);// 窗口宽高
		setLocation(200, 100);// 窗口左上角坐标相对屏幕位置
		setVisible(true);// 窗口可视化

		new PaintThread().start();// 启动重画线程

		// 窗口监听，使加载的窗口能关闭
		addWindowListener(new WindowAdapter() {

			@Override
			// 重写windowClosing方法
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

		});
	}

	/**
	 * 使加载的图片动起来，定义一个重画窗口的线程类
	 * 
	 * @author Administrator
	 * 
	 */
	class PaintThread extends Thread {

		public void run() {
			while (true) {
				repaint();// 重画窗口
				try {
					Thread.sleep(40);// cpu休息40毫秒
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
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
