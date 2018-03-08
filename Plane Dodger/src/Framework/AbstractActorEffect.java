package Framework;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class AbstractActorEffect extends BaseActor {

	public AbstractActorEffect(float x, float y, Stage s, String sheet, int rows, int cols) {
		super(x, y, s);
		
		loadAnimationFromSheet(sheet, rows, cols, 0.02f, false);		
	}
	
	@Override
	public void act(float dt) {
		super.act(dt);
		
		if(isAnimationFinished())
			remove();
	}
	

}
