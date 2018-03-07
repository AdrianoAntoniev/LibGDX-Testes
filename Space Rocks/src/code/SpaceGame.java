package code;

public class SpaceGame extends BaseGame {
	@Override
	public void create() {
		super.create();
		setActiveScreen(new LevelScreen());
	}
}
