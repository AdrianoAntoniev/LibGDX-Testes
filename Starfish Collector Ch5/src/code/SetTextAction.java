package code;

import com.badlogic.gdx.scenes.scene2d.Action;

public class SetTextAction extends Action {
	protected String textToDisplay;
	
	public SetTextAction(String textToDisplay) {
		this.textToDisplay = textToDisplay;
	}
	
	@Override
	public boolean act(float dt) {
		DialogBox db = (DialogBox)target;
		db.setText(textToDisplay);
		return true;
		
	}

}
