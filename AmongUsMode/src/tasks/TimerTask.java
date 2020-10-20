package tasks;

import org.bukkit.scheduler.BukkitRunnable;

public class TimerTask extends BukkitRunnable {

	private int time;
	
	public TimerTask(int time) {
		this.time=time;
	}
	
	@Override
	public void run() {
		
		if (time == 0) cancel();
		
		time--;
	}
	
	public int getTime() {
		return time;
	}

}
