package innerClassController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来管理并触发事件的实际控制框架
 * @author Administrator
 *
 */
public class Controller {//总控制
	private List<Event> eventList = new ArrayList<Event>();//事件容器
	public void addEvent (Event c) {//添加事件
		eventList.add(c);
	}
	/**
	 * run()方法循环遍历eventList，寻找就绪的ready()、要运行的Event对象
	 * 对找到的每一个就绪事件，试用期对象打印其信息，调用action方法、然后移除
	 */
	public void run() {
		while(eventList.size()>0) {//还有未处理事件存在
			for(Event e : new ArrayList<Event>(eventList)) {//遍历一个个事件
				if(e.ready()) {//事件就绪
					System.out.println(e);
					e.action();
					eventList.remove(e);//事件移除
				}
			}
		}
	}
}
