import java.awt.Color;
import acm.util.RandomGenerator;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 200;
	public static final int APPLICATION_HEIGHT = 200;
	
	public void run(){	
		setUpWorld();
		runWorld();
	}
	
	public void init(){
	    resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	}
	
	public void setUpWorld(){
		theWorld = new World(20,20);
		addCreatures();
		theWorldCanvas = this.getGCanvas();
	}
	
	public void runWorld(){
		drawWorld();
		for(int i=0; i<10;i++){
			theWorld.letTimePass();
			pause(500);
			drawWorld();
		}
	}	
	
	public void addCreatures() {
		for (int i=0; i<3; i++) {
			theWorld.getCreatureList().add(new Grass( new Location(rgen.nextInt(0, theWorld.getWidth()),rgen.nextInt(0, theWorld.getHeight())), theWorld ));
			theWorld.getCreatureList().add(new Species1(new Location(rgen.nextInt(0, theWorld.getWidth()),rgen.nextInt(0, theWorld.getHeight())), theWorld));
			theWorld.getCreatureList().add(new Species2(new Location(rgen.nextInt(0, theWorld.getWidth()),rgen.nextInt(0, theWorld.getHeight())), theWorld));
			theWorld.getCreatureList().add(new Species3(new Location(rgen.nextInt(0, theWorld.getWidth()),rgen.nextInt(0, theWorld.getHeight())), theWorld));
		}

		theWorld.getCreatureList().add(new Grass( new Location(rgen.nextInt(0, theWorld.getWidth()),rgen.nextInt(0, theWorld.getHeight())), theWorld ));
		theWorld.getCreatureList().add(new Grass( new Location(rgen.nextInt(0, theWorld.getWidth()),rgen.nextInt(0, theWorld.getHeight())), theWorld ));
		}
	
	public void drawWorld(){
		drawBlankWorld();
		drawCreatures();
	}
	
	public void drawBlankWorld(){
		for(int row = 0 ; row<theWorld.getWidth(); row++)
			for(int col=0; col<theWorld.getHeight(); col++){
				GRect r = new GRect(row*10, col*10, 10, 10);
				r.setFillColor(Color.WHITE);
				r.setFilled(true);
				theWorldCanvas.add(r);
			}
	}
	
	public void drawCreatures(){
		for(LifeForm x: theWorld.getCreatureList()){
			GRect r = new GRect (x.getMyLocation().getX()*10, x.getMyLocation().getY()*10,10,10);
			r.setFillColor(x.getMyColor());
			r.setFilled(true);
			theWorldCanvas.add(r);
		}
	}
}
