import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {
	private List<ElevatorController> controllers;
	private ElevatorSchedulerFactory schedulerFactory;
	
	public ElevatorManager(int controllerCount) {
		controllers = new ArrayList<ElevatorController>(controllerCount);
		for (int i = 0; i < controllerCount; i++) {
			ElevatorController controller = new ElevatorController(i + 1);
			controllers.add(controller);
		}
	}

	void requestElevator(int destination, Direction direction) {
		ElevatorScheduler scheduler = schedulerFactory.getElevatorScheduler();
		int selectedElevator = scheduler.selectElevator(controllers, destination, direction);
		controllers.get(selectedElevator).gotoFloor(destination);
	}
}