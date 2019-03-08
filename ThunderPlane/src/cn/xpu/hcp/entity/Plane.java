package cn.xpu.hcp.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import cn.xpu.hcp.game.GameFrame;
import cn.xpu.hcp.tools.Constant;
import cn.xpu.hcp.tools.GameImage;
import cn.xpu.hcp.tools.PlaySound;

public class Plane {
	private static Random r = new Random(); 
	private int step=r.nextInt(50);//����߶��ٲ� ������Boss�л�
	public int lifeNum = 2;
	int randIndex;
	int oldIndex;
	public long eatStart;
	public boolean eated=false;
	public int count=0;//��¼���˶��ٸ������ӵ����䱦
	public int x,y;//�ɻ���λ��
	private boolean good;//�ɻ����һ��ǶԷ����л�����������Ϊtrue���л�����Ϊfalse
	private boolean isAlive = true;//�����ɻ��Ƿ����
	private boolean isBoss;//���ڵз��ɻ��Ƿ���boss����
	private GameFrame gf;
	private int speed;//�ɻ��ƶ��ٶ�
	private boolean bL,bU,bR,bD;
	private int life = 100;
	public int WIDTH,HEIGHT;//�ӵ��Ŀ�͸�
	private Direction dir = Direction.STOP;//Plane���ƶ�״̬,��ʼ��ʱĬ����STOP  
	private static Image[] myImgs=new Image[28];//����ҷ�����ͼƬ������
	private static Image[] enemyImgs = new Image[23];//��ŵз���ͨ���͵�ͼƬ
	private static Image[] bossImgs = new Image[8];//��ŵз�boss���͵�ͼƬ
	private Image ensureImg;//����ȷ����ͼƬ
	
	static{
		//�ҷ��ɻ�����ͼƬ
		myImgs[0]=GameImage.getImage("resources/plane1.png");  
	    myImgs[1]= GameImage.getImage("resources/plane2.png");  
	    myImgs[2]= GameImage.getImage("resources/plane3.png");  
	    myImgs[3]= GameImage.getImage("resources/plane4.png");  
	    myImgs[4]= GameImage.getImage("resources/plane5.png");  
	    myImgs[5]= GameImage.getImage("resources/plane6.png");  
	    myImgs[6]= GameImage.getImage("resources/plane7.png");  
	    myImgs[7]= GameImage.getImage("resources/plane8.png");  
	          
	    myImgs[8]= GameImage.getImage("resources/plane9.png");  
	    myImgs[9]= GameImage.getImage("resources/plane10.png");  
	    myImgs[10]= GameImage.getImage("resources/plane11.png");  
	    myImgs[11]= GameImage.getImage("resources/plane12.png");  
	    myImgs[12]= GameImage.getImage("resources/plane13.png");  
	    myImgs[13]= GameImage.getImage("resources/plane14.png");  
	    myImgs[14]= GameImage.getImage("resources/plane15.png");  
	    myImgs[15]= GameImage.getImage("resources/plane16.png");
	    
	    myImgs[16]= GameImage.getImage("resources/plane17.png");  
	    myImgs[17]= GameImage.getImage("resources/plane18.png");  
	    myImgs[18]= GameImage.getImage("resources/plane19.png");  
	    myImgs[19]= GameImage.getImage("resources/plane20.png");  
	    myImgs[20]= GameImage.getImage("resources/plane21.png");  
	    myImgs[21]= GameImage.getImage("resources/plane22.png");  
	    myImgs[22]= GameImage.getImage("resources/plane23.png");  
	    myImgs[23]= GameImage.getImage("resources/plane24.png");
	    
	    myImgs[24]= GameImage.getImage("resources/plane25.png");  
	    myImgs[25]= GameImage.getImage("resources/plane26.png");  
	    myImgs[26]= GameImage.getImage("resources/plane27.png");  
	    myImgs[27]= GameImage.getImage("resources/plane28.png");  
	    
	    //�з���ͨ�ɻ�����ͼƬ
	    enemyImgs[0]=GameImage.getImage("resources/enemy1.png");  
	    enemyImgs[1]= GameImage.getImage("resources/enemy2.png");  
	    enemyImgs[2]= GameImage.getImage("resources/enemy3.png");  
	    enemyImgs[3]= GameImage.getImage("resources/enemy4.png");  
	    enemyImgs[4]= GameImage.getImage("resources/enemy5.png");  
	    enemyImgs[5]= GameImage.getImage("resources/enemy6.png");  
	    enemyImgs[6]= GameImage.getImage("resources/enemy7.png");  
	    enemyImgs[7]= GameImage.getImage("resources/enemy8.png");  
	          
	    enemyImgs[8]= GameImage.getImage("resources/enemy9.png");  
	    enemyImgs[9]= GameImage.getImage("resources/enemy10.png");  
	    enemyImgs[10]= GameImage.getImage("resources/enemy11.png");  
	    enemyImgs[11]= GameImage.getImage("resources/enemy12.png");  
	    enemyImgs[12]= GameImage.getImage("resources/enemy13.png");  
	    enemyImgs[13]= GameImage.getImage("resources/enemy14.png");  
	    enemyImgs[14]= GameImage.getImage("resources/enemy15.png");  
	    enemyImgs[15]= GameImage.getImage("resources/enemy16.png");
	    
	    enemyImgs[16]= GameImage.getImage("resources/enemy17.png");  
	    enemyImgs[17]= GameImage.getImage("resources/enemy18.png");  
	    enemyImgs[18]= GameImage.getImage("resources/enemy19.png");  
	    enemyImgs[19]= GameImage.getImage("resources/enemy20.png");  
	    enemyImgs[20]= GameImage.getImage("resources/enemy21.png");  
	    enemyImgs[21]= GameImage.getImage("resources/enemy22.png");  
	    enemyImgs[22]= GameImage.getImage("resources/enemy23.png"); 
	    
	    //boss����ͼƬ
	    bossImgs[0]=GameImage.getImage("resources/boss1.png");  
	    bossImgs[1]= GameImage.getImage("resources/boss2.png");  
	    bossImgs[2]= GameImage.getImage("resources/boss3.png");  
	    bossImgs[3]= GameImage.getImage("resources/boss4.png");  
	    bossImgs[4]= GameImage.getImage("resources/boss5.png");  
	    bossImgs[5]= GameImage.getImage("resources/boss6.png");  
	    bossImgs[6]= GameImage.getImage("resources/boss7.png");  
	    bossImgs[7]= GameImage.getImage("resources/boss8.png"); 
	}
	
	
	public Plane(int x,int y,int speed,boolean good,boolean boss,GameFrame gf){
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.good = good;
		this.gf = gf;
		this.isBoss = boss;
		if(good==true){
			randIndex = r.nextInt(28);
			ensureImg = myImgs[randIndex];
			randIndex = r.nextInt(3);
		}else{
			if(isBoss){//�����boss���ͣ���boss������ѡ��
				randIndex = r.nextInt(8);
				ensureImg = bossImgs[randIndex];
				randIndex = r.nextInt(2);
			}else{
				randIndex = r.nextInt(23);
				ensureImg = enemyImgs[randIndex];
				dir = Direction.D;//��ͨ�л�����ֻ������
				randIndex = r.nextInt(8);
			}
		}
		WIDTH = ensureImg.getWidth(null);
		HEIGHT = ensureImg.getHeight(null);
		
	}
	public void setRandIndex(int randIndex) {
		this.randIndex = randIndex;
	}
	public void draw(Graphics g){
		if(isAlive==false){//�ɻ�����������
			gf.es.remove(this);
			return;
		}
		g.drawImage(ensureImg, x, y, null);
		move(); 
	}
	public boolean isBoss() {
		return isBoss;
	}
	public void setX(int x) {
		this.x = x-ensureImg.getWidth(null)/2;
	}
	public void setY(int y) {
		this.y = y-ensureImg.getHeight(null)/2;
	}
	public void setIsBoss(){
		this.isBoss = true;//����Ϊboss
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void Press(KeyEvent e) {
		int key = e.getKeyCode();  
	    switch(key) {  
	    case KeyEvent.VK_LEFT :  
	        bL = true;  
	        break;  
	    case KeyEvent.VK_UP :  
	        bU = true;  
	        break;  
	    case KeyEvent.VK_RIGHT :  
	        bR = true;  
	        break;  
	    case KeyEvent.VK_DOWN :  
	        bD = true;  
	        break;  
	    } 
	    locateDirection();
	}
	public void Release(KeyEvent e) {
		int key = e.getKeyCode();  
	    switch(key) {  
	    case KeyEvent.VK_SPACE:  
	    case KeyEvent.VK_CONTROL:  
	    	fire();//Ԥ������
	        break;  
	    case KeyEvent.VK_LEFT :  
	        bL = false;  
	        break;  
	    case KeyEvent.VK_UP :  
	        bU = false;  
	        break;  
	    case KeyEvent.VK_RIGHT :  
	        bR = false;  
	        break;  
	    case KeyEvent.VK_DOWN :  
	        bD = false;  
	        break;  
	    }
	    locateDirection();
	}
	
	public void fire() {
		if(isAlive==false)return;//����Ҳ��û����ı�Ҫ��
		if(good==true){//�л����䲻��������
			new PlaySound("Beam.mp3", false).start();
		}
		int xPos = -10;  
		int yPos = -10;  
		Bullet m = new Bullet(xPos, yPos,10,randIndex, good,this.isBoss,this.gf); 
		if(good==true){
			m.setX(this.x + this.WIDTH/2 - m.getWIDTH()/2);
			m.setY(this.y   - m.getHEIGHT()+20);
		}else{//�л������ӵ���λ�ò�ͬ
			m.setX(this.x + this.WIDTH/2 - m.getWIDTH()/2);
			m.setY(this.y +this.HEIGHT);
		}
		if(isBoss){
			if(r.nextInt(40)>38){
				gf.bs.remove(m);
				Bullet bossM = new Bullet(xPos, yPos, 15, 4, good, isBoss, gf);
				bossM.setX(this.x + this.WIDTH/2 - m.getWIDTH()/2);
				bossM.setY(this.y +this.HEIGHT);
				gf.bs.add(bossM);
//				System.out.println("boss ���䳬���ڵ�");
				return;
			}
			if(r.nextInt(40)>=33){
    			for(int i=0;i<5;i++){
    				SuperMissile2 missile2 = new SuperMissile2(gf, this.x + this.WIDTH/2 - m.getWIDTH()/2, this.y +this.HEIGHT, false, gf.myplane);
    				if(i==0){
    					missile2.Costhita-=0.1;
    					missile2.Sinthita+=0.1;
    				}
    				if(i==2){
    					missile2.Costhita-=0.1;
    					missile2.Sinthita-=0.1;
    				}
    				if(i==3){
    					missile2.Costhita+=0.1;
    					missile2.Sinthita-=0.1;
    				}
    				if(i==4){
    					missile2.Costhita+=0.1;
    					missile2.Sinthita+=0.1;
    				}
    				missile2.speed = 5;
    				gf.supermissiles.add(missile2);
    			}
    		}
		}
		gf.bs.add(m);//����������ӵ�  

	}
	public void fire(long t){
		if(r.nextInt(40)>36)
			fire();
	}
	
	void locateDirection() {//���ݰ�������Plane�ƶ�����-->dir  
	    if(bL && !bU && !bR && !bD) dir = Direction.L;  
	    else if(bL && bU && !bR && !bD) dir = Direction.LU;  
	    else if(!bL && bU && !bR && !bD) dir = Direction.U;  
	    else if(!bL && bU && bR && !bD) dir = Direction.RU;  
	    else if(!bL && !bU && bR && !bD) dir = Direction.R;  
	    else if(!bL && !bU && bR && bD) dir = Direction.RD;  
	    else if(!bL && !bU && !bR && bD) dir = Direction.D;  
	    else if(bL && !bU && !bR && bD) dir = Direction.LD;  
	    else if(!bL && !bU && !bR && !bD) dir = Direction.STOP;  
	} 
	
	//Plane���ƶ�����  
	void move() {  
	    switch(dir) {  
	    case L:  
	        x -= speed;  
	        break;  
	    case LU:  
	        x -= speed;  
	        y -= speed;  
	        break;  
	    case U:  
	        y -= speed;  
	        break;  
	    case RU:  
	        x += speed;  
	        y -= speed;  
	        break;  
	    case R:  
	        x += speed;  
	        break;  
	    case RD:  
	        x += speed;  
	        y += speed;  
	        break;  
	    case D:  
	        y += speed;  
	        break;  
	    case LD:  
	        x -= speed;  
	        y += speed;  
	        break;  
	    case STOP:  
	        break;  
	    }  
	    if(good==true){
	    	//���ﴰ��߽磬����������ƶ�  
	    	if(x < 0) x = 0;  
	    	if(y < 30) y = 30;  
	    	if(x + ensureImg.getWidth(null) > Constant.GAME_WIDTH) x = Constant.GAME_WIDTH - ensureImg.getWidth(null);  
	    	if(y + ensureImg.getHeight(null) > Constant.GAME_HEIGHT) y = Constant.GAME_HEIGHT - ensureImg.getHeight(null);  
	    }else{
	    	if(isBoss){//boss�л�ֻ�������ƶ������в������ҳ���
	    		Direction[] dirs = Direction.values();  
	    		if(step == 0) {  
	    			step = r.nextInt(50) + 3;  
	    			int rn = r.nextInt(2);  
	    			dir = dirs[rn];//��ȡ�������  
//	    			this.speed=0;
	    		}
	    		step --;  
	    		if(r.nextInt(40) >= 35) this.fire();//���������������38�Ϳ���
	    		
	    		
	    		
	    		if(x < 0) x = 0; 
	    		if(x + ensureImg.getWidth(null) > Constant.GAME_WIDTH) x = Constant.GAME_WIDTH - ensureImg.getWidth(null);  
		    	if(y + ensureImg.getHeight(null) > Constant.GAME_HEIGHT) y = Constant.GAME_HEIGHT - ensureImg.getHeight(null);  
	    	}else{
	    		if(r.nextInt(40) > 38) this.fire();
	    		if(y>(Constant.GAME_HEIGHT)){
	    			isAlive = false;
	    		}
	    	}
	    }
	}
	public boolean getAlive() {
		return this.isAlive;
	}
	public boolean isgood() {
		return this.good;
	}
	public Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	public void setAlive(boolean live) {
		this.isAlive = live;
	} 

	public void setBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}
	
	public boolean eat(Treasure t) {
		if(this.isAlive && t.isLive() && this.getRect().intersects(t.getRect())) {
			if(t.type==1){
				this.life = 100;
			}else{
				count++;
				if(count>=2){
					eated = true;
					this.randIndex = r.nextInt(12)%(4) + 9;
					eatStart = System.currentTimeMillis();
					new PlaySound("baozou.mp3", false).start();//�����ɳ����ڵ������ű�������
				}else{
					this.randIndex = r.nextInt(8)%(6) + 3;
					oldIndex = randIndex;
				}
				
			}
			t.setLive(false);
			return true;
		}
		return false;
	}
	
	public void back(){
		this.randIndex = oldIndex;
	}
}
