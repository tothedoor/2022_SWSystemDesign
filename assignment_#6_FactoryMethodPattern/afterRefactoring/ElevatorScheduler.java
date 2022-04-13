import java.util.List;

public interface ElevatorScheduler {
	public int selectElevator(List<ElevatorController> controllers, int destination, Direction direction);
}
