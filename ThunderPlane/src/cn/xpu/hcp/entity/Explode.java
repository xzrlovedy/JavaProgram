package cn.xpu.hcp.entity;

import java.awt.Graphics;
import java.awt.Image;

import cn.xpu.hcp.game.GameFrame;
import cn.xpu.hcp.tools.GameImage;

public class Explode {  
    int x,y;  
    static Image images[] = new Image[11];  
    int count;  
    public boolean live=true;//���ñ�ը������  
    private GameFrame gf;  
    static{  
        for(int i=1;i<=6;i++){  
            images[i] = GameImage.getImage("resources/blast_0_"+i+".png");  
            images[i].getWidth(null);//��������������  
        }  
    }  
    public void draw(Graphics g) {  
        if(!live) {  
            gf.explodes.remove(this);//��ը�����˾��Ƴ�  
            return;  
        }  
        if(live){  
            if(count<=10){  
                g.drawImage(images[count], (int)x, (int)y, null);  
                count++;  
            }else{  
                live=false;//���б�ըͼƬ����������ˣ���ը����  
            }  
        }  
    }  
    public Explode(int x, int y,GameFrame gf) {  
        super();  
        this.x = x;  
        this.y = y;  
        this.gf = gf;  
    }  
    public void setXY(int x,int y) {  
        this.x = x;  
        this.y = y;  
    }  
} 
