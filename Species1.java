import java.awt.Color;

import acm.util.RandomGenerator;




public class Species1 extends Animal {
	
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public Species1(Location loc, World w) {
		super(loc, w);
		myLifeSpan= 6;
		myColor = Color.BLUE;
		survivalNum = 5;
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
	public void reproduce() {
		if (survivalNum>5) {
			Location myLoc = getMyLocation();
			if(myWorld.locIsFilled(new Location(myLoc.getX()+1,myLoc.getY()+1))==false) {
				myWorld.getCreatureList().add(new Species1(new Location(myLoc.getX()+1,myLoc.getY()+1), myWorld));
			}
		}
	}

	public void eat() {
		for(int x=-1; x< 2; x++) {
			for (int y= -1; y<2;y++) {
				Location neighboringSqr = new Location(getMyLocation().getX()+x, getMyLocation().getY()+y);
				for(int j=0; j< myWorld.getCreatureList().size();j++) {
					LifeForm creature = myWorld.getCreatureList().get(j);
					if(creature.getMyLocation().equals(neighboringSqr)) {
						if (creature.getMyLocation().equals(getMyLocation())==false) {
							if(creature instanceof Grass) {
								creature.alive =false;
								survivalNum++;
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void runAway() {
		// TODO Auto-generated method stub
		
	}

}


