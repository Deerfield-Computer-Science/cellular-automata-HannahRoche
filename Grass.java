import java.util.ArrayList;

public class Grass extends Plant {
	
	public Grass(Location l, World w) {
		super(l,w);
		myLifeSpan = 3;
	}
	
	public void reproduce() {
		int newX = myLocation.getX()+1;
		int newY = myLocation.getY(); 
		if (myWorld.locIsFilled(new Location(newX, newY))==false) {
			myWorld.getCreatureList().add(new Grass(new Location(newX,newY), myWorld));
		}
		newX= newX-1;
		newY= newY+1;
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
			survivalNum--;
		}
		
	}

}
