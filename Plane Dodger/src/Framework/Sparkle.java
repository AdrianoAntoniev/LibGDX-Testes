package Framework;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Sparkle extends AbstractActorEffect {
	private static final String sheet = "assets/sparkle.png";
	private static final int rows = 8;
	private static final int cols = 8;
	
	public Sparkle(float x, float y, Stage s) {
		super(x, y, s, sheet, rows, cols);
	}

}
