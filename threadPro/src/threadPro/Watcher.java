package threadPro;
/**
 * 消费者（观看者）
 * @author Administrator
 *
 */
public class Watcher implements Runnable {
	private Movie m ;
	
	public Watcher(Movie m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			m.watch();
		}
	}

}
