package Framework;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Plane extends BaseActor {

	public Plane(float x, float y, Stage s) {
		super(x, y, s);
		String[] fileNames = {"assets/planeGreen0.png",
							  "assets/planeGreen1.png",	
							  "assets/planeGreen2.png",
							  "assets/planeGreen1.png"};
		loadAnimationFromFiles(fileNames, 0.1f, true);
		setMaxSpeed(800);
		setBoundaryPolygon(8);
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		//simulate force of gravity
		setAcceleration(800);
		accelerateAtAngle(270);
		applyPhysics(dt);
		
		//stop plane from passing through the ground
		for(BaseActor ground: BaseActor.getList(this.getStage(), "Framework.Ground")) {
			if(this.overlaps(ground)) {
				setSpeed(0);
				preventOverlap(ground);
			}
		}
		
		if(getY() + getHeight() > getWorldBounds().height) {
			setSpeed(0);
			boundToWorld();
		}
	}
	
	public void boost() {
		setSpeed(300);
		setMotionAngle(90);
	}
	
	
}
