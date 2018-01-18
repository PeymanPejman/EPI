import java.util.concurrent.*;

public class worker {
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
	private static int count=1;

	public static void main (String[] args){
		final Runnable sleep = new Runnable() {
			@Override
			public void run() {
				System.out.println("Before work");
				for (int i=0; i<1000; i++) {
					for (int j=0; j<1000; j++){
						System.out.print(i + "\r");
					}
				}				
				System.out.println("After work");	
			}	
		};
		final ScheduledFuture<?> sleepHandle = scheduler.scheduleAtFixedRate(sleep, 0,5, TimeUnit.SECONDS);

		final Runnable check = new Runnable() {
			@Override
			public void run() {
				if (count ==2 ){
					sleepHandle.cancel(true);}
				count++;
				System.out.println("isDone: " + sleepHandle.isDone());
				System.out.println("isCanceled: " + sleepHandle.isCancelled());
			}	
		};
		final ScheduledFuture<?> checkHandle = scheduler.scheduleAtFixedRate(check, 0,1, TimeUnit.SECONDS);
	}
}
