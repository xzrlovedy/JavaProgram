package test2;

import java.awt.Graphics;
import java.awt.Image;
/**
 * С��켣�˶�
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class GameFrame2 extends MyFrame {
	Image img = GameUtil.getImage("image/xiaoqiu.png");
	Constant c = new Constant();
	
	
	//����ͼƬ�ĺ�������
	private double x=5,y=30;
//	private double dgree = 3.14/3;//����Ƕ�
//	private double speed = 10;//�����ٶ�
//	private boolean left;
//	private boolean up;
	@Override//��д���෽��paint��ʹ���س��Ĵ����ܻ��������ص�����̬�����ã�main��������ã��Զ�ִ��
	public void paint(Graphics g) {
		
		//����ͼƬ
	    g.drawImage(img, (int)x, (int)y, null);
	    //С����Ȼͣ��
	    if(c.speed>0){
	    	c.speed-=0.02;
	    }else{
	    	c.speed=0;
	    }
	    //С����
	    x+= c.speed*Math.cos(c.dgree);
        y+= c.speed*Math.sin(c.dgree);
        //��ײ����
        if(y>c.Game_Heigth-60||y<30){
	    	c.dgree = -c.dgree;
	    }
	    if(x>c.Game_Width-60||x<5){
	    	c.dgree = Math.PI-c.dgree;
	    }
	    
/*�ı����ҷ���
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
	    //�ı����·���
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
		GameFrame2 gf = new GameFrame2();//������Ϸ���ڶ���
		gf.launchFrame();//���ü��ش��ں���
	}
}
