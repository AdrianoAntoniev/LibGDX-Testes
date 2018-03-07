package code;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Shield extends BaseActor {

	public Shield(float x, float y, Stage s) {
		super(x, y, s);
		loadTexture("assets/shields.png");
		
		Action pulse = Actions.sequence(
					Actions.scaleTo(1.05f, 1.05f),
					Actions.scaleTo(0.95f, 0.95f));
		addAction(Actions.forever(pulse));
	}

}
