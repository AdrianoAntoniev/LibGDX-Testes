package Framework;

import com.badlogic.gdx.scenes.scene2d.Stage;



/**
 * Base class for use in Sky and Ground classes
 * @author Adriano
 *
 */
public abstract class LandscapeActor extends BaseActor {
	protected float speed;
	protected float motionAngle;
	protected String textureFilename;
	
	/**
	 * Constructor for the class, which is the basis for the classes
	 * Sky and Ground.
	 * @param x the position of the axis X;
	 * @param y the position of the axis Y
	 * @param s the Stage in which the object will be inserted;
	 * @param textureFilename the path of the image in the project;
	 * @param speed the velocity of the object;
	 * @param motionAngle the angle of the object.
	 * 
	 * Please pay attention to the order of the params!!!
	 */
	protected LandscapeActor(float x, float y, Stage s, 
			String textureFilename, float speed, float motionAngle) {
		super(x,y,s);
		this.textureFilename = textureFilename;
		this.speed = speed;
		this.motionAngle = motionAngle;
		
		loadTexture(textureFilename);
		setSpeed(speed);
		setMotionAngle(motionAngle);
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		super.applyPhysics(dt);
		
		if(getX() + getWidth() < 0) {
			performWhenInLeftSide();
		}
	}

	public abstract void performWhenInLeftSide();
}
