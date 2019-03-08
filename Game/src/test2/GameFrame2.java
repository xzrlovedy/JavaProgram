package test2;

import java.awt.Graphics;
import java.awt.Image;
/**
 * 小球轨迹运动
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class GameFrame2 extends MyFrame {
	Image img = GameUtil.getImage("image/xiaoqiu.png");
	Constant c = new Constant();
	
	
	//加载图片的横纵坐标
	private double x=5,y=30;
//	private double dgree = 3.14/3;//发射角度
//	private double speed = 10;//控制速度
//	private boolean left;
//	private boolean up;
	@Override//重写父类方法paint，使加载出的窗口能画东西；回调，多态的运用，main里无需调用，自动执行
	public void paint(Graphics g) {
		
		//加载图片
	    g.drawImage(img, (int)x, (int)y, null);
	    //小球自然停下
	    if(c.speed>0){
	    	c.speed-=0.02;
	    }else{
	    	c.speed=0;
	    }
	    //小球方向
	    x+= c.speed*Math.cos(c.dgree);
        y+= c.speed*Math.sin(c.dgree);
        //碰撞反向
        if(y>c.Game_Heigth-60||y<30){
	    	c.dgree = -c.dgree;
	    }
	    if(x>c.Game_Width-60||x<5){
	    	c.dgree = Math.PI-c.dgree;
	    }
	    
/*改变左右方向
	    if(left){
	    	x-=3;
	    }else{
	    	x+=3;
	    }
	    if(x>500-60){
	    	left = true;
	    }
	    if(x<0){
	    	left = false;
	    }
	    //改变上下方向
	    if(up){
	    	y-=4;
	    }else{
	    	y+=4;
	    }
	    if(y>500-60){
	    	up = true;
	    }
	    if(y<30){
	    	up = false;
	    }*/
	    
	}
	
	

	public static void main(String[] args) {
		GameFrame2 gf = new GameFrame2();//建立游戏窗口对象
		gf.launchFrame();//调用加载窗口函数
	}
}
