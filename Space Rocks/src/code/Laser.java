package code;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Laser extends BaseActor {

	public Laser(float x, float y, Stage s) {
		super(x,y,s);
		loadTexture("assets/laser.png");
		
		addAction(Actions.delay(1));
		addAction(Actions.after(Actions.fadeOut(0.5f)));
		addAction(Actions.after(Actions.removeActor()));
		
		setSpeed(400);
		setMaxSpeed(400);
		setDeceleration(0);
	}
	
	@Override
	public void act(float dt) {
		// TODO Auto-generated method stub
		super.act(dt);
		applyPhysics(dt);
		wrapAroundWorld();
	}

}