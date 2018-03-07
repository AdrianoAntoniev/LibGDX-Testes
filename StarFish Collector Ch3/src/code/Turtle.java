package code;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Turtle extends BaseActor {

	public Turtle(float x, float y, Stage s) {
		super(x, y, s);
		
		setAcceleration(400);
		setMaxSpeed(100);
		setDeceleration(400);
		
		String[] fileNames = 
			{"assets/turtle-1.png", "assets/turtle-2.png", "assets/turtle-3.png",
			 "assets/turtle-4.png", "assets/turtle-5.png", "assets/turtle-6.png"};
		
		loadAnimationFromFiles(fileNames, 0.1f, true);
		
		setBoundaryPolygon(8);
	}

	@Override
	public void act(float dt) {
		super.act(dt);
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) accelerateAtAngle(180);
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) accelerateAtAngle(0);
		if(Gdx.input.isKeyPressed(Keys.UP)) accelerateAtAngle(90);
		if(Gdx.input.isKeyPressed(Keys.DOWN)) accelerateAtAngle(270);
		
		applyPhysics(dt);
		setAnimationPaused(!isMoving());
		
		if(getSpeed() > 0)
			setRotation(getMotionAngle());
		
		boundToWorld();
	}
}
