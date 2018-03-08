package Framework;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class EnemyPlane extends AbstractPlane {
	private static final String[] filenames = { "assets/planeRed0.png", 
												"assets/planeRed1.png",
												"assets/planeRed2.png", 
												"assets/planeRed1.png"};
	
	public EnemyPlane(float x, float y, Stage s) {
		super(x, y, s, filenames);
		setSpeed(100);
		setMotionAngle(180);
	}

}
