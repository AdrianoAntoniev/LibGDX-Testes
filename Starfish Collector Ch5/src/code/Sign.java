package code;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Sign extends BaseActor {
	private String text;
	private boolean viewing;
	
	public Sign(float x, float y, Stage s) {
		super(x, y, s);
		loadTexture("assets/sign.png");
		text = " ";
		viewing = false;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isViewing() {
		return viewing;
	}

	public void setViewing(boolean viewing) {
		this.viewing = viewing;
	}
		

}
