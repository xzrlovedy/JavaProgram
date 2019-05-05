package enumAndSwitch;
/**
 * ��switch��ʹ��enum
 * ͨ������£�Switchֻ��ʹ��int�ͻ�char���ͣ������Ժ�enum������ʹ�ã���enum�ṩ��һ���������
 * @author Administrator
 *
 */
enum Signal{
	GREEN,YELLOW,RED;
}
class TrafficLight{
	Signal color = Signal.RED;
	public void change() {
		switch(color) {
		case RED:
			color = Signal.GREEN;
			break;
		case GREEN:
			color = Signal.YELLOW;
			break;
		case YELLOW:
			color = Signal.RED;
			break;
		}
	}
	public String toString() {
		return "The TrafficLight is "+color;
	}
}
public class EnumAndSwitch {
	public static void main(String[] args) {
		//System.out.println(Signal.values());
		TrafficLight t = new TrafficLight();
		for(int i=0;i<7;i++) {
			System.out.println(t);
			t.change();
		}
	}
}
