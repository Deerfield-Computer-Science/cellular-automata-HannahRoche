import java.util.ArrayList;
import acm.util.RandomGenerator;



public class Grass extends Plant {

	private RandomGenerator rgen = RandomGenerator.getInstance();	
	
	public Grass(Location l, World w) {
		super(l,w);
		myLifeSpan = 3;
		survivalNum =4;
	}
	
	public void reproduce() {
		int newX = myLocation.getX()+rgen.nextInt(-1,1);
		int newY = myLocation.getY()+rgen.nextInt(-1,1); 
		if (myWorld.locIsFilled(new Location(newX, newY))==false) {
			myWorld.getCreatureList().add(new Grass(new Location(newX,newY), myWorld));
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		if (myWorld.getisSunny()) {
			survivalNum++;
		} else {
			survivalNum-=2;
		}
		
	}

}
