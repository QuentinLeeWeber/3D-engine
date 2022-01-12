package pac;

public class Time {
	Time(){
		
	}
	double last_time = System.nanoTime();
	public double deltaTime;

	
	

	public void update() {	
		double time = System.nanoTime();
	    deltaTime = (double) ((time - last_time)/ 1000000000);
	    //System.out.println(time - last_time);
	    last_time = time;	
	    
	}
}
