package cn.xpu.hcp.entity;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;

import cn.xpu.hcp.game.GameFrame;
import cn.xpu.hcp.tools.Constant;
import cn.xpu.hcp.tools.GameImage;

public class Bullet {
	private static Random r = new Random(); 
	int randIndex;
	private int x,y;//�ӵ���λ��
	int WIDTH,HEIGHT;//�ӵ��Ŀ�͸�

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private boolean good;//�ӵ����һ��ǶԷ����л�������ģ�������Ϊtrue���л�����Ϊfalse
	private boolean isAlive = true;//�����ӵ��Ƿ�Ӧ����ʧ�����л��ų��������Ϊfalse
	private int power;//�ӵ���ɱ����
	private int speed;//�ӵ����ƶ��ٶ�
	private boolean isBoss;//�Ƿ�Ϊboss�����ӵ�
	private Direction dir;//�ӵ��ķ����������ϣ��з�����
	private GameFrame gf;
	
	private static Image[] myImgs=new Image[13];//����ҷ��ӵ�ͼƬ������
	private static Image[] enemyImgs = new Image[9];//��ŵз���ͨ�����ӵ���ͼƬ
	private static Image[] bossImgs = new Image[5];//��ŵз�boss�����ӵ���ͼƬ
	private Image ensureImg;//����ȷ����ͼƬ
	
	static{
		//�ҷ��ɻ��ӵ�ͼƬ
		//�ͼ��ӵ�
		myImgs[0]=GameImage.getImage("resources/m5.png");  
	    myImgs[1]= GameImage.getImage("resources/m6.png");  
	    myImgs[2]= GameImage.getImage("resources/m7.png");  
	    //�м��ӵ�
	    myImgs[3]= GameImage.getImage("resources/m1.png"); 
	    //�߼��ӵ�
	    myImgs[4]= GameImage.getImage("resources/m2.png");  
	    myImgs[5]= GameImage.getImage("resources/m3.png");  
	    myImgs[6]= GameImage.getImage("resources/m4.png"); 
	    myImgs[7]= GameImage.getImage("resources/m8.png");
	    myImgs[8]= GameImage.getImage("resources/m9.png");
	    //�����ڵ�
	    myImgs[9]= GameImage.getImage("resources/m10.png");  
	    myImgs[10]= GameImage.getImage("resources/m11.png"); 
	    myImgs[11]= GameImage.getImage("resources/m12.png");
	    myImgs[12]= GameImage.getImage("resources/m13.png");
	    
	    //�з���ͨ�ɻ��ӵ�ͼƬ
	    enemyImgs[0]=GameImage.getImage("resources/em2.png");  
	    enemyImgs[1]= GameImage.getImage("resources/em3.png");  
	    enemyImgs[2]= GameImage.getImage("resources/em4.png");  
	    enemyImgs[3]= GameImage.getImage("resources/em5.png");  
	    enemyImgs[4]= GameImage.getImage("resources/em6.png"); 
	    
	    enemyImgs[5]= GameImage.getImage("resources/em7.png");  
	    
	    enemyImgs[6]= GameImage.getImage("resources/em8.png");  
	    enemyImgs[7]= GameImage.getImage("resources/em9.png"); 
	    enemyImgs[8]= GameImage.getImage("resources/em1.png"); 
	    
	    //boss�ӵ�ͼƬ
	    //�ͼ��ӵ�
	    bossImgs[0]=GameImage.getImage("resources/bm3.png");  
	    bossImgs[1]= GameImage.getImage("resources/bm5.png");
	    //�߼��ӵ�
	    bossImgs[2]= GameImage.getImage("resources/bm4.png");
	    //����
	    bossImgs[3]= GameImage.getImage("resources/bm1.png");  
	    bossImgs[4]= GameImage.getImage("resources/bm2.png"); 
	}
	
	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public Bullet(int x,int y,int speed,int randIndex,boolean good,boolean boss,GameFrame gf){
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.good = good;
		this.gf = gf;
		this.randIndex = randIndex;
		this.isBoss = boss;
		if(good==true){
			//��ʼֻ���ǵͼ��ӵ���ͨ��ʰȡ���������ӵ�
			ensureImg = myImgs[randIndex];
			//���ݲ�ͬ�ȼ����ӵ����ò�ͬ�ȼ���ɱ����
			if(randIndex>=0&&randIndex<=2){
				this.power = 10;
			}else{
				if(randIndex==3){
					this.power = 20;
				}else{
					if(randIndex>=4&&randIndex<=8){
						this.power = 50;
					}else{
						this.power = 100;
					}
				}
			}
			dir = Direction.U;
			WIDTH = ensureImg.getWidth(null);
			HEIGHT = ensureImg.getHeight(null);
		}else{
			dir = Direction.D;
			if(isBoss){
				//��ʼ����ͼ��ӵ����������߼��ʹ���
//				this.randIndex = r.nextInt(2);
				this.randIndex = randIndex;
				ensureImg = bossImgs[this.randIndex];
				WIDTH = ensureImg.getWidth(null);
				HEIGHT = ensureImg.getHeight(null);
				//���ݲ�ͬ�ȼ����ӵ����ò�ͬ�ȼ���ɱ����
				if(randIndex>=0&&randIndex<=1){
					this.power = 10;
				}else{
					if(randIndex==2){
						this.power = 20;
					}else{
						if(randIndex>=3&&randIndex<=4){
							this.power = 50;
						}
					}
				}
			}else{
				ensureImg = enemyImgs[randIndex];
				WIDTH = ensureImg.getWidth(null);
				HEIGHT = ensureImg.getHeight(null);
				//���ݲ�ͬ�ȼ����ӵ����ò�ͬ�ȼ���ɱ����
				if(randIndex>=0&&randIndex<=4){
					this.power = 2;
				}else{
					if(randIndex==5){
						this.power = 5;
					}else{
						if(randIndex>=6&&randIndex<=8){
							this.power = 15;
						}
					}
				}
			}
		}
		
	}
	
	public void draw(Graphics g){
		if(!isAlive){
			gf.bs.remove(this);//�����ӵ�
			return;//�ӵ���ʧ�ˣ�����
		}
		g.drawImage(ensureImg,x,y,null);
		move();
	}
	
	private void move() {  
        switch(dir) {  
        case U:  
        	y -= speed;  
        	break; 
        case D:
        	y += speed;  
        	break;  
        }  
        if(x < 0 || y < 0 || x > Constant.GAME_WIDTH || y > Constant.GAME_HEIGHT) {  
            isAlive = false;//���������Ϊfalse  
        }
	}
	
	public boolean hitPlane(Plane p) {  
	    if(this.isAlive && this.getRect().intersects(p.getRect()) && p.getAlive() && this.good != p.isgood()) {//���Ǽ����ӵ����ҷ�������ײ  
	    	this.isAlive = false;//�ӵ�Ӧ����ʧ 
	    	//����boss���ͣ������л����ҵ��ӵ���ɱ����100%
	        if(this.good&&p.isBoss()==false){
	        	p.setAlive(false);
	        }
	    	p.setLife(p.getLife()-this.power);
	        if(p.getLife()<=0||p.getAlive()==false){
	        	if(p.isgood()==false){
	        		p.setAlive(false);//�ɻ�����  
	        		Explode e = new Explode(x, y, gf);  
	        		gf.explodes.add(e);//��ӱ�ը
	        		return true;
	        	}else{
	        		if(p.lifeNum==0){
	        			p.setAlive(false);//�ɻ�����  
		        		Explode e = new Explode(x, y, gf);  
		        		gf.explodes.add(e);//��ӱ�ը
		        		return true;
	        		}else{
	        			p.lifeNum--;
	        			p.setLife(100);
	        			p.setAlive(true);//�ɻ�����  
		        		return true;
	        		}
	        	}
	        }
	    }  
	    return false;  
	}  
	      
	private Rectangle getRect() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	public boolean hitPlanes(List<Plane> planes) {  
	    for(int i=0; i<planes.size(); i++) {  
	        if(hitPlane(planes.get(i))) {  
	            return true;  
	        }  
	    }  
	    return false;  
	}
}
