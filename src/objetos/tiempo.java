package objetos;

public class tiempo {
	
	private long delta, lastTime;
	private long time;
	private boolean run;
	
	public tiempo() {
		delta = 0;
		lastTime = 0;
		run = false;
	}
	
	public void run(long time) {
		run = true;
		this.time = time;
		
	}
	
	public void actualizar() {
		
		if (run) {
			delta += System.currentTimeMillis() - lastTime;
		}
		
		if (delta >= time) {
			run = false;
			delta = 0;
		}
		
		lastTime = System.currentTimeMillis();
		
		
	}
	
	public boolean isRun() {
		
		return run;

	}

}
