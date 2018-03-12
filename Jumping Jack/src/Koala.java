import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Koala extends BaseActor {
	private Animation stand;
	private Animation walk;
	private float walkAcceleration;
	private float walkDeceleration;
	private float maxHorizontalSpeed;
	private float gravity;
	private float maxVerticalSpeed;
	
	private Animation jump;
	private float jumpSpeed;
	private BaseActor belowSensor;
	
	public Koala(float x, float y, Stage s) {
		super(x, y, s);
		
		stand = loadTexture("assets/koala/stand.png");		
		String path = "assets/koala/walk-*.png";
		
		String[] walkFileNames = {path.replace("*", "1"), path.replace("*", "2"),
								  path.replace("*", "3"), path.replace("*", "2")};
		
		walk = loadAnimationFromFiles(walkFileNames, 0.2f, true);
		
		maxHorizontalSpeed = 100;
		walkAcceleration   = 200;
		walkDeceleration   = 200;
		gravity            = 700;
		maxVerticalSpeed   = 1000;
		
		jump = loadTexture("assets/koala/jump.png");
		jumpSpeed = 450;
		setBoundaryPolygon(6);
		belowSensor = new BaseActor(0, 0, s);
		belowSensor.loadTexture("assets/white.png");
		belowSensor.setSize(this.getWidth() - 8, 8);
		belowSensor.setBoundaryRectangle();
		belowSensor.setVisible(true);
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		if(Gdx.input.isKeyPressed(Keys.LEFT))
			accelerationVec.add(-walkAcceleration, 0);
		if(Gdx.input.isKeyPressed(Keys.RIGHT))
			accelerationVec.add(walkAcceleration, 0);
		
		accelerationVec.add(0, -gravity);
		velocityVec.add(accelerationVec.x * dt, accelerationVec.y * dt);
		
		if(!Gdx.input.isKeyPressed(Keys.RIGHT) && !Gdx.input.isKeyPressed(Keys.LEFT)) {
			float decelerationAmount = walkDeceleration * dt;
			float walkDirection = -1;
			
			if(velocityVec.x > 0) 
				walkDirection *= -1;
			
			
			float walkSpeed = Math.abs(velocityVec.x);
			
			walkSpeed = (walkSpeed - decelerationAmount < 0) ? 
							0 : 
							walkSpeed - decelerationAmount; 
			
			velocityVec.x = walkSpeed * walkDirection;
			
			velocityVec.x = MathUtils.clamp(velocityVec.x, -maxHorizontalSpeed, maxHorizontalSpeed);
			velocityVec.y = MathUtils.clamp(velocityVec.y, -maxVerticalSpeed, maxVerticalSpeed);
			
			moveBy(velocityVec.x * dt, velocityVec.y * dt);
			accelerationVec.set(0, 0);
			
			belowSensor.setPosition(getX() + 4, getY() -8);
			
			alignCamera();
			boundToWorld();
			
//			if(velocityVec.x == 0)
//				setAnimation(stand);
//			else
//				setAnimation(walk);
			
			if(this.isOnSolid()) {
				belowSensor.setColor(Color.GREEN);
				if(velocityVec.x == 0)
					setAnimation(stand);
				else
					setAnimation(walk);
			} else {
				belowSensor.setColor(Color.RED);
				setAnimation(jump);
			}
			
			if(velocityVec.x > 0) 
				setScaleX(1);
			else
				setScaleX(-1);	
		}
	}
	
	public boolean belowOverlaps(BaseActor actor) {
		return belowSensor.overlaps(actor);
	}

	public boolean isOnSolid() {
		for(BaseActor actor : BaseActor.getList(getStage(), "Solid")) {
			Solid solid = (Solid)actor;
			if(belowOverlaps(solid) && solid.isEnabled())
				return true;
		}
		return false;
	}
	
	public void jump() {
		velocityVec.y = jumpSpeed;
	}
}
