import java.awt.Color;

import acm.util.RandomGenerator;
//Minor changes from Species2 are listed below
public class Species3 extends Animal {
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public Species3(Location loc, World w) {
		super(loc, w);
		myLifeSpan = 9;
		myColor = Color.BLACK;
		survivalNum =5;
		
	}

	@Override
	public void move() {
		Location previous = getMyLocation();
		int x = previous.getX();
		int y = previous.getY();
		previous.setX(x+(rgen.nextInt(-1, 1)));
		previous.setY(y+(rgen.nextInt(-1, 1)));
		if(myWorld.locIsFilled(previous) ==false) {
			setMyLocation(previous);
		}
		
	}

	@Override
	public void runAway() {
	}

	@Override
	public void reproduce() {
		if (survivalNum>5) {
			Location newLoc = new Location(myLocation.getX()+1,myLocation.getY()+1);
			if(myWorld.locIsFilled(newLoc) ==false) {
				myWorld.getCreatureList().add(new Species3(newLoc, myWorld));
				survivalNum-=2;
			}
		}
		
	}

	@Override
	public void eat() {
		for(int x=-1; x< 2; x++) {
			for (int y= -1; y<2;y++) {
				Location neighboringSqr = new Location(getMyLocation().getX()+x, getMyLocation().getY()+y);
				for(int j=0; j< myWorld.getCreatureList().size();j++) {
					LifeForm creature = myWorld.getCreatureList().get(j);
					if(creature.getMyLocation().equals(neighboringSqr)) {
						if (creature.getMyLocation().equals(getMyLocation())==false) {
							if(creature instanceof Species2) {
								creature.alive =false;
								survivalNum++;
							}
						}
					}
				}
			}
		}
	}
		
}