
public class Sungard extends Robot {
	public Sungard(final String name) {
		super(name, new TaekwonVAttackStrategy(), new SungardMoveStrategy());
	}

}
