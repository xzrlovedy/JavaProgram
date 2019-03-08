package cn.xpu.hcp.entity;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import cn.xpu.hcp.game.GameFrame;
import cn.xpu.hcp.tools.Constant;
import cn.xpu.hcp.tools.GameImage;
import cn.xpu.hcp.tools.PlaySound;

public class CreateEnemyThread extends Thread{
	private GameFrame gf;
	private static Random r = new Random();
	private static AtomicInteger count = new AtomicInteger(1);

	public CreateEnemyThread(GameFrame gf){
		this.gf = gf;
		System.out.println("check...");
	}

	@Override
	public void run() {
		while(true){
			if((System.currentTimeMillis()-gf.myplane.eatStart)/1000>=10&&gf.myplane.eated==true){
				gf.myplane.back();//�����ڵ�ʹ��10�룬��ԭ
				gf.myplane.count = 0;
				gf.myplane.eated = false;
			}
			if(gf.myplane.getLife()<=10&&gf.myplane.getLife()>0&&r.nextInt(40)>=38){
				Treasure t = new Treasure(0,gf);//����ֵС��10ʱϵͳ���ˢ����Ѫ���䱦
				gf.ts.add(t);
			}
			if(gf.myplane.getLife()>0){
				if(r.nextInt(40)>38){
					SuperMissile superM = new SuperMissile(gf, -100, -100, true);
					superM.x = (gf.myplane.x + gf.myplane.WIDTH/2 - superM.WIDTH/2);
					superM.y = (gf.myplane.y   - superM.HEIGHT+20);
					gf.supermissiles.add(superM);
					gf.supermissiles.add(superM);
					System.out.println("����װ��...");
				}
			}
			if((System.currentTimeMillis()-gf.start)/1000>=90){//һ�ְ�󣬴�����������ͨ���ˣ�boss��ʼ����
				
				if((System.currentTimeMillis()-gf.start)/1000%30==0&&r.nextInt(40)>=37){
					if(gf.ts.size()==0){
						Treasure t = new Treasure(gf);//����ʱ��ڵ㣬���ˢ���䱦
						gf.ts.add(t);
					}
				}
				
				if(gf.es.size()==0){
//					System.out.println("û����ͨ�л���...");
					if(gf.flagMap.get("success")==false&&gf.flagMap.get("boss")==false){
//						System.out.println("��û��ͨ�أ�����boss");
						new PlaySound("bosscoming.mp3", false);
						gf.pbg.stop();
						gf.pbg = new PlaySound("bossing.mp3", true);
						gf.pbg.start();
						Plane boss = new Plane(r.nextInt(500),50,5,false,true,gf);//boss�л�
						boss.setLife(10000);//boss����ֵΪ10000
						gf.flagMap.put("boss", true);
						gf.es.add(boss);
					}else{
						gf.pbg.stop();
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						count.getAndIncrement();
//						System.out.println("������boss����һ��...\n�����ǵ�"+count.get()+"��");
						if(count.get()==7){
							System.out.println("count="+count);
							count.set(1);
							System.out.println(count.get());
						}
						System.out.println("�޸�success=false");
//						gf.success.set(false);
						gf.flagMap.put("success", false);
						gf.flagMap.put("boss", false);
						gf.boss = gf.temp;
						gf.gameBg = GameImage.getImage("resources/background"+count.get()+".bmp");
						gf.yPos = -1*(gf.gameBg.getHeight(null)-Constant.GAME_HEIGHT)+1;
						gf.yPos2 = gf.yPos - gf.gameBg.getHeight(null);
						gf.start = System.currentTimeMillis();
						gf.myplane.setLife(100);
						gf.pbg = new PlaySound("bgmusic.mp3", true);
						gf.pbg.start();
						
						
					}
					
				}
			}else{
				if(gf.es.size()<6){//ʹ�л�����������6��
					Plane ePlane = new Plane(r.nextInt(500),-r.nextInt(500),5,false,false,gf);//�л�
					ePlane.setBoss(false);
					gf.es.add(ePlane);
				}
			}
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//ʹCPUЪ��
		}
	}

}
