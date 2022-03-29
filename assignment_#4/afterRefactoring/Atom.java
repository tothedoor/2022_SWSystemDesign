public class Atom extends Robot {
	public Atom(final String name) {
		super(name, new AtomAttackStrategy(), new AtomMoveStrategy());
	}
}