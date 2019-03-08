package test2;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * MyFrame��װ�࣬��Ϸ���÷���
 * 
 * @author Administrator
 * 
 */
@SuppressWarnings("serial")
public class MyFrame extends Frame {

	Constant c = new Constant();
	// ���ش��ں���
	public void launchFrame() {
		setSize(c.Game_Width, c.Game_Heigth);// ���ڿ��
		setLocation(200, 100);// �������Ͻ����������Ļλ��
		setVisible(true);// ���ڿ��ӻ�

		new PaintThread().start();// �����ػ��߳�

		// ���ڼ�����ʹ���صĴ����ܹر�
		addWindowListener(new WindowAdapter() {

			@Override
			// ��дwindowClosing����
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

		});
	}

	/**
	 * ʹ���ص�ͼƬ������������һ���ػ����ڵ��߳���
	 * 
	 * @author Administrator
	 * 
	 */
	class PaintThread extends Thread {

		public void run() {
			while (true) {
				repaint();// �ػ�����
				try {
					Thread.sleep(40);// cpu��Ϣ40����
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
	//Java˫���壬��ֹ��Ļ��˸
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
