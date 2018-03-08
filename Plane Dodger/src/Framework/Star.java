package Framework;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Star extends LandscapeActor {	
	private static final String fileName = "assets/star.png";
	private static final float speed = 100;
	private static final float motionAngle = 180;
	
	protected Star(float x, float y, Stage s) {
		super(x, y, s, fileName, speed, motionAngle);
		
		Action pulse = Actions.sequence(
					Actions.scaleTo(1.2f, 1.2f, 0.5f),
					Actions.scaleTo(1.0f, 1.0f, 0.5f));
		addAction(Actions.forever(pulse));
	}

	@Override
	public void performWhenInLeftSide() {
		remove();
	}

}
