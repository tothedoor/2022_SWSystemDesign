import java.util.Calendar;

public class TimeBasedSchedulerFactory implements ElevatorSchedulerFactory {

public ElevatorScheduler getElevatorScheduler() {
		final int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		ElevatorScheduler scheduler;
		
		if (hour < 12) // in the morning
			scheduler = new ResponseTimeScheduler(); // use ResponseTimeScheduler
		else // in the afternoon
			scheduler = new ThroughputScheduler(); // use ThroughputScheduler
		
		return scheduler;
	}
}
