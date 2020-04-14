public abstract class Animal extends LifeForm {

	public Animal(Location loc, World w) {
		super(loc, w);
	}
	
	public abstract void move();
	
	public abstract void eat();
	
	public abstract void runAway();
	
}
