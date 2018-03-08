package Framework;

import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class AbstractPlane extends BaseActor {

	public AbstractPlane(float x, float y, Stage s, String[] filenames) {
		super(x, y, s);
		loadAnimationFromFiles(filenames, 0.1f, true);
		setBoundaryPolygon(8);
	}

	public void act(float dt) {
		super.act(dt);
		applyPhysics(dt);
	}
}
