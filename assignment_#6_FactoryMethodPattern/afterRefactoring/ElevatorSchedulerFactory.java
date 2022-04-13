import java.util.Calendar;

public class ElevatorSchedulerFactory {
	public ElevatorScheduler getElevatorScheduler() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour < 12)
			return new ResponseTimeScheduler();
		else
			return new ThroughputScheduler();
	}
}
