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
 * 飞机游戏窗口，继承MyFrame类
 * 
 * @author xzr
 * 
 */
public class PlaneGameFrame extends MyFrame {
	private static final long serialVersionUID = 1L;
	
	Image bg = GameUtil.getImage("images/bg.jpg"); // 加载背景图片
	Plan p = new Plan("images/plan.png", 100, 100);
	
	ArrayList<Bullet> bulletList = new ArrayList<Bullet>();//容器，存放子弹数量,泛型以后加
	
	Date startTime;		//游戏开始时间
	Date endTime;		//结束时间
	
	Explode bao;		//飞机爆炸对象

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		
		//将下方launchFrame类生成的子弹画在画布上，采用遍历的方式
		for(int i=0;i<bulletList.size();i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//飞机与子弹碰撞检测
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng){
				p.setLive(false);//飞机死亡
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
			Font f = new Font("宋体",Font.BOLD,50);
			g.setFont(f);
			g.drawString("GAME OVER", Constant.GAME_WIDTHN/2-100,Constant.GAME_HEIGHT/2);//弹出死亡字体
			Font f1 = new Font("宋体",Font.BOLD,20);
			g.setFont(f1);
			long period = (endTime.getTime()-startTime.getTime())/1000;		//计算生存时间，毫秒/1000
			g.drawString("生存时间"+period+"秒",Constant.GAME_WIDTHN/2-100,Constant.GAME_HEIGHT/2+50);
			g.setColor(c);
		}
	}

	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}

	/**
	 * 重写父类的launchFrame方法，才能用下面的键盘监听
	 * 游戏开始，加载窗口
	 */
	public void launchFrame() {
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		//生成子弹,放到容器中
		for(int i=0;i<30;i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		startTime = new Date();
	}

	/**
	 * 定义内部类，可以方便的使用外部类的属性 此方法监听键盘动作，控制飞机移动
	 * 
	 * @author Administrator
	 * 
	 */
	class KeyMonitor extends KeyAdapter {

		/**
		 * 键盘按下监听
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("按下：" + e.getKeyCode());
			// 上下左右移动
			p.addDirection(e);
		}

		/**
		 * 键盘按钮弹起监听
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			p.minusDirection(e);
		}
	}
}
