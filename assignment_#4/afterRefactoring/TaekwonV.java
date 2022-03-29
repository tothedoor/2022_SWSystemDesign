public class TaekwonV extends Robot {
	
	public TaekwonV(final String name) {
		super(name, new TaekwonVAttackStrategy(), new TaekwonVMoveStrategy());
	}
	
} 