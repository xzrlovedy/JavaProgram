package cn.xpu.hcp.tools;

import java.io.InputStream;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 * 
 * ����ʹ�ö��̣߳�������Ч
 *
 */
public class PlaySound extends Thread{
	
	private String mp3Url;
	
	private boolean isLoop;
	
	public PlaySound(String mp3Url, boolean isLoop) {
		super();
		this.mp3Url = mp3Url;
		this.isLoop = isLoop;
	}

	public void run() {
		
		do{
			
			//��ȡ��Ƶ�ļ���
			InputStream mp3 = PlaySound.class.getClassLoader().getResourceAsStream("music/"+mp3Url);
			
			try {
			
				//����������
				AdvancedPlayer adv = new AdvancedPlayer(mp3);
				
				//����
				adv.play();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}while(isLoop);
	}
	
	public static void main(String[] args) {
		
		new PlaySound("bgmusic.mp3", true).start();
		
	}
}
