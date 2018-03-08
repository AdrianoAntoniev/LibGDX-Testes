package Framework;

import com.badlogic.gdx.Input.Keys;

public class LevelScreen extends BaseScreen {
	Plane plane;
	public void initialize() {
		new Sky(0, 0, mainStage);
		new Sky(800, 0, mainStage);
		new Ground(0,0, mainStage);
		new Ground(800,0, mainStage);
		
		plane = new Plane(100, 500, mainStage);
		BaseActor.setWorldBounds(800,600);
	}

	public void update(float dt) {

	}
	
	public boolean keyDown(int keyCode) {
		if(keyCode == Keys.SPACE) {
			plane.boost();
		}
		
		return true;
	}
}