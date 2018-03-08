package Framework;

public class LevelScreen extends BaseScreen {
	public void initialize() {
		new Sky(0, 0, mainStage);
		new Sky(800, 0, mainStage);
		new Ground(0,0, mainStage);
		new Ground(800,0, mainStage);
	}

	public void update(float dt) {

	}
}