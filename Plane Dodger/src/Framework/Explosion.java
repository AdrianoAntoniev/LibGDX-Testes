package Framework;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Explosion extends AbstractActorEffect {
	private static final String sheet = "assets/explosion.png";
	private static final int rows = 6;
	private static final int cols = 6;
	
	public Explosion(float x, float y, Stage s) {
		super(x, y, s, sheet, rows, cols);
	}

}
