package code.version2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class GameBeta extends Game {
	protected Stage mainStage;

	public abstract void update(float dt);
	public abstract void initialize();

	@Override
	public void create() {
		mainStage = new Stage();
		initialize();
	}

	
	@Override
	public void render() {
		float dt = Gdx.graphics.getDeltaTime();
		mainStage.act();
		update(dt);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		mainStage.draw();
	}

}
