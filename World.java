import java.util.ArrayList;

import acm.util.RandomGenerator;

public class World {
	
	private int width;
	private int height;
	private boolean isSunny;
	private ArrayList<LifeForm> creatureList;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public World(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		if (rgen.nextInt(0,1)==0) {
			isSunny=true;
		}else {
			isSunny=false;
		}
		this.creatureList = new ArrayList<LifeForm>();
	}
	
	public void letTimePass(){
		makeNewCreatures();
		eatThings();
		//creatureList.get(2).move();
		//creaturesGetOlder();
		purgeTheDead();		
	}
	
	public void eatThings() {
		for(int i=0; i<creatureList.size();i++) {
			creatureList.get(i).eat();
			
		}
	}
	
	public void makeNewCreatures() {
		
		int currentSizeOfCreatureList = creatureList.size();
		System.out.println("size of list is "+currentSizeOfCreatureList);
		for(int i=0; i< currentSizeOfCreatureList; i++) {
			creatureList.get(i).reproduce();
		}
	}
	
	public void purgeTheDead(){
		int i=0;
		while(i<creatureList.size()){
			if(creatureList.get(i).isDead())
				creatureList.remove(i);
			else
				i++;
		}	
	}
	
	public void creaturesGetOlder(){
		for( LifeForm l:creatureList){
			l.age(1);
		}
	}
	
	public boolean locIsFilled(Location loc1) {
		for (int i=0; i<creatureList.size();i++) {
			if (creatureList.get(i).myLocation.equals(loc1)) {
				return true;
			}
		}
		return false;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean getisSunny() {
		return isSunny;
	}
	public void setIsSunny(boolean sunny) {
		isSunny = sunny;
	}
	
	public ArrayList<LifeForm> getCreatureList() {
		return creatureList;
	}
	public void setCreatureList(ArrayList<LifeForm> creatureList) {
		this.creatureList = creatureList;
	}

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height
				+ ", creatureList=" + creatureList + "]";
	}
}
