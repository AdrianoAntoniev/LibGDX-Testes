package code;

public class StarfishGame extends BaseGame {

	@Override
	public void create() {
		super.create();
		setActiveScreen(new MenuScreen());
		
	}

}
