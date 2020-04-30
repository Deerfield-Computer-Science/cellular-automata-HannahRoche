import java.awt.Color;

import acm.util.RandomGenerator;




public class Species2 extends Animal {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public Species2(Location loc, World w) {
		super(loc, w);
		myLifeSpan= 10;
		myColor = Color.MAGENTA;
		survivalNum = 3;
	}

	@Override
	public void move() {
		Location previous = getMyLocation();
		int x = previous.getX();
		int y = previous.getY();
		previous.setX(x+(rgen.nextInt(-2, 2)));
		previous.setY(y+(rgen.nextInt(-2, 2)));
		if(myWorld.locIsFilled(previous) ==false) {
			setMyLocation(previous);
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
							if(creature instanceof Species1) {
								creature.alive =false;
								survivalNum++;
							} else {
								survivalNum--;
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
/*
	public int inAPack() {
		int packNum =0;
		for(int x=-1; x< 2; x++) {
			for (int y= -1; y<2;y++) {
				Location neighboringSqr = new Location(getMyLocation().getX()+x, getMyLocation().getY()+y);
				for(int j=0; j< myWorld.getCreatureList().size();j++) {
					LifeForm creature = myWorld.getCreatureList().get(j);
					if(creature.getMyLocation().equals(neighboringSqr)) {
						if (creature.getMyLocation().equals(getMyLocation())==false) {
							if(creature instanceof Species1) {
								packNum++;
							}
						}
					}
				}
			}
			
		}
		return packNum;	
	} */
	
	@Override
	public void reproduce() {
			Location myLoc = getMyLocation();
			if(myWorld.locIsFilled(new Location(myLoc.getX()+1,myLoc.getY()+1))==false) {
				myWorld.getCreatureList().add(new Species2(new Location(myLoc.getX()+1,myLoc.getY()+1), myWorld));
			} else if (myWorld.locIsFilled(new Location(myLoc.getX()+1,myLoc.getY()))==false) {
				myWorld.getCreatureList().add(new Species2(new Location(myLoc.getX()+1,myLoc.getY()), myWorld));
			}
		
	}
	
	
}
