package code;

import com.badlogic.gdx.Input.Keys;

public class LevelScreen extends BaseScreen {
	private Spaceship spaceship;
	
	@Override
	public void initialize() {
		BaseActor space = new BaseActor(0,0, mainStage);
		space.loadTexture("assets/space.png");
		space.setSize(800, 600);
		BaseActor.setWorldBounds(space);
		
		spaceship = new Spaceship(400, 300, mainStage);
	}

	@Override
	public void update(float dt) {
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.X)
			spaceship.warp();
		
		return false;
	}

}
