
public class Outside {

	private double GPA;
	private static long start;
    private static long end;
    private static boolean started;
    public void setGPA(double lesson1,double lesson2,double lesson3,double lesson4,double lesson5)
	
	{
			 this.GPA=(lesson1+lesson2+lesson3+lesson4+lesson5)/5;
	}
		
	public double getGPA()
	{
		return GPA;
	}

	 // Controll timer if it is stop 
    private static boolean isStopped() {
        return !started;
    }

    // Controll timer if it is start 
    
    private static boolean isStarted() {
        return started;
    }
 

    // start timer
    public static void start() {
        if (isStopped()) {
            startTimer();
        } else {
            throw new RuntimeException("The timer has already started.\n");
        }
    }
 
    private static void startTimer() {
        start = System.nanoTime();
        started = true;
    }
 

    // stop timer
    public static void stop() {
        if (isStarted()) {
            stopTimer();
        } else {
            throw new RuntimeException("The timer failed to start.\n");
        }
    }
 
    private static void stopTimer() {
        end = System.nanoTime();
        started = false;
    }
 

    // take info from timer
    public static long getElapsedTime() {
        if (isStopped()) {
            return end - start;
        } else {
            throw new RuntimeException("The timer failed to start.\n");
        }
 
    }
 

    // take info from timer
    public static double getElapsedMilliseconds() {
        double seconds = (double) getElapsedTime() / 1000000.0;
        return seconds;
    }
 

    // take info from timer
    public static double getElapsedSeconds() {
        double seconds = (double) getElapsedTime() / 1000000000.0;
        return seconds;
    }
	
}
