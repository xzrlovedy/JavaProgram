package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏窗口
 * @author xzr
 *
 */
@SuppressWarnings("serial")
public class GameFrame extends Frame {//AWT简要，GUI编程，几乎淘汰，java不适合写桌面软件
	
	Image img = GameUtil.getImage("image/feiji.png");
	
	
	/**
	 * 加载窗口，窗口坐标以左上角为基点
	 */
	public void launchFrame(){
		setSize(500,500);//窗口宽高
		setLocation(100,100);//窗口左上角坐标相对屏幕位置
		setVisible(true);//窗口可视化
		
		new PaintThread().start();//启动重画线程
		
		/**
		 * 窗口监听，使加载的窗口能关闭
		 */
		addWindowListener(new WindowAdapter(){

			@Override//重写windowClosing方法
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	//加载图片的横纵坐标
	int x=300,y=1;
	
	/**
	 * 重写父类方法paint，使加载出的窗口能画东西；回调，多态的运用，main里无需调用，自动执行。
	 * 窗口内元素的坐标相对于窗口左上角，而不是屏幕！！！
	 * 线程启动后此方法被反复调用！new PaintThread().start();//启动重画线程
	 */
	@Override
	public void paint(Graphics g) {
		g.drawRect(100, 100, 200, 200);//在窗口画矩形，坐标相对窗口
		g.drawOval(100, 100, 200, 200);//矩形内切圆
		
		//加载图片
	    g.drawImage(img, x, y, null);
	    x-=3;
	    y+=2;
	    
		//字体问题
		Font f = new Font("宋体",Font.BOLD,50);//字体构造器
		g.setFont(f);
		g.drawString("游戏窗口", 200, 120);
		
		//画笔问题
		Color c = g.getColor();//保存初始颜色
		g.setColor(Color.blue);//设置颜色
		g.fillRect(100, 100, 20, 20);//填充矩形
		g.setColor(c);//还原初始颜色，避免以后出错
	}
	
	/**
	 * 使加载的图片动起来，定义一个重画窗口的线程类。
	 * 重写父类run方法。
	 * @author Administrator
	 *
	 */
	class PaintThread extends Thread{
		
		public void run(){
			while(true){
				repaint();//重画窗口
				try {
					Thread.sleep(40);//cpu休息40毫秒
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

	public static void main(String[] args) {
		GameFrame gf = new GameFrame();//建立游戏窗口对象
		gf.launchFrame();//调用加载窗口函数
	}
}
