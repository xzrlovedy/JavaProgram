package innerClassController;

/**
 * 特定实现：温室的运作 控制灯光、水、温度调节器的开关 以及响铃和重新启动系统
 * 
 * @author Administrator
 *
 */
public class GreenHouseControls extends Controller {
	private boolean light = false;
	//开灯事件
	public class LightOn extends Event {
		public LightOn(long delayTime) {
			super(delayTime);
		}
		public void action() {
			//按钮动作，开灯
			light = true;
		}
		public String toString() {
			return "开灯！";
		}
	}
	//关灯事件
	public class LightOff extends Event {
		public LightOff(long delayTime) {
			super(delayTime);
		}

		public void action() {
			//按钮关灯
			light = false;
		}
		public String toString() {
			return "关灯！";
		}
	}

	// **************************************************//
	private boolean water = false;
	//打开水龙头
	public class WaterOn extends Event {
		public WaterOn(long delayTime) {
			super(delayTime);
		}
		public void action() {
			//水龙头开关动作
			water = true;
		}
		public String toString() {
			return "温室浇水开启！";
		}
	}
	//关闭水龙头
	public class WaterOff extends Event {
		public WaterOff(long delayTime) {
			super(delayTime);
		}
		public void action() {
			//水龙头开关动作
			water = false;
		}
		public String toString() {
			return "温室浇水关闭！";
		}
	}
	//**********************************************//
	//温度调节器开关
	private String thermostat = "Day";
	public class ThermostatNight extends Event {
		public ThermostatNight(long delayTime) {
			super(delayTime);
		}
		public void action() {
			// Put hardware control code here.
			thermostat = "Night";
		}
		public String toString() {
			return "温度调节到晚上！";
		}
	}
	public class ThermostatDay extends Event {
		public ThermostatDay(long delayTime) {
			super(delayTime);
		}
		public void action() {
			// Put hardware control code here.
			thermostat = "Day";
		}
		public String toString() {
			return "温度调节到白天";
		}
	}
	//响铃事件
	public class Bell extends Event {
		public Bell(long delayTime) {
			super(delayTime);
		}
		public void action() {
			addEvent(new Bell(delayTime));
		}
		public String toString() {
			return "响铃声!";
		}
	}
	//**********************************************//
	//重启系统事件
	public class Restart extends Event {
		private Event[] eventList;

		public Restart(long delayTime, Event[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for (Event e : eventList)
				addEvent(e);
		}
		public void action() {
			for (Event e : eventList) {
				e.start(); //重启每一个事件
				addEvent(e);
			}
			start(); //启动当前事件
			addEvent(this);
		}
		public String toString() {
			return "重启系统";
		}
	}
	//*********************************************//
	//终止事件
	public static class Terminate extends Event {
		public Terminate(long delayTime) {
			super(delayTime);
		}
		public void action() {
			System.exit(0);
		}
		public String toString() {
			return "停止！";
		}
	}
}
