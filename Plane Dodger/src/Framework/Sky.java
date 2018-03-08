package Framework;



import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Class responsible for scroll the sky screen image.
 * @author Adriano 
 *
 */
public class Sky extends LandscapeActor {
	private static final String fileName = "assets/sky.png";
	private static final float speed = 25;
	private static final float motionAngle = 180;
	
	public Sky(float x, float y, Stage s) {
		super(x, y, s, fileName, speed, motionAngle);		
	}

	@Override
	public void performWhenInLeftSide() {
		super.moveBy(2 * getWidth(), 0);
	}
}
