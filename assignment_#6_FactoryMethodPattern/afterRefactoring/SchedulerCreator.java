public class SchedulerCreator {
	public static ElevatorScheduler create(ElevatorSchedulerFactory factory) {
		return factory.getElevatorScheduler();
	}
}
