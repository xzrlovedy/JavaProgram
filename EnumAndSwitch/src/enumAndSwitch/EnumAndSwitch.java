package enumAndSwitch;
/**
 * 在switch中使用enum
 * 通常情况下，Switch只能使用int型或char类型，但可以和enum类联合使用，是enum提供的一项便利功能
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
