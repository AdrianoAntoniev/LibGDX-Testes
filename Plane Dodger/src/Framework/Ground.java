package Framework;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Class responsible for scroll the ground screen image.
 * @author Adriano 
 *
 */

public class Ground extends LandscapeActor {
	private static final String fileName = "assets/ground.png";
	private static final float speed = 100;
	private static final float motionAngle = 180;
	
	protected Ground(float x, float y, Stage s) {
		super(x, y, s, fileName, speed, motionAngle);		
	}

}
