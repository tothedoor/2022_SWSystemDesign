import java.util.ArrayList;
import java.util.List;

public abstract class ScoreRecordSubject {
	private List<View> viewList = new ArrayList<>();
	
	public void attach(View view) {
		viewList.add(view);
	}
	
	public void detach(View view) {
		viewList.remove(view);
	}
	
	protected void notifyViews() {
		for (View view : viewList) {
			view.update();
		}
	}
}
