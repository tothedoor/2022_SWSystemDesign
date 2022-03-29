public abstract class Robot {
	private final String name;
	private final AttackStrategy attackStrategy;
	private final MoveStrategy moveStrategy;
	
	public Robot(final String name, final AttackStrategy attackStrategy, final MoveStrategy moveStrategy) {
		this.name = name;
		this.attackStrategy = attackStrategy;
		this.moveStrategy = moveStrategy;
	}

	public String getName() {
		return name;
	}
	
	public void attack() {
		this.attackStrategy.attack();
	}

	public void move() {
		this.moveStrategy.move();
	}
	
}
